package com.ousmane.gestiondestock.services.impl;

import com.ousmane.gestiondestock.dto.ArticleDto;
import com.ousmane.gestiondestock.exception.EntityNotFoundException;
import com.ousmane.gestiondestock.exception.ErrorCodes;
import com.ousmane.gestiondestock.exception.InvalidEntityException;
import com.ousmane.gestiondestock.model.Article;
import com.ousmane.gestiondestock.repository.ArticleRepository;
import com.ousmane.gestiondestock.services.ArticleService;
import com.ousmane.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("l'article n'est pas valide{}",dto);
            throw new InvalidEntityException("l'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID,errors);
        }

        Article savedArticle = articleRepository.save(ArticleDto.toEntity(dto));
        return ArticleDto.fromEntity(savedArticle);
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null ){
            log.error("Article id est null");
            return null;
        }

        Optional<Article> article = articleRepository.findById(id);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
            new EntityNotFoundException(
                    "Aucun Article avec l'Id = " + id + "n'a été trouver dans la bdd",
                    ErrorCodes.ARTICLE_NOT_FOUND
            )
        );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)){
            log.error("Code Article est null");
            return null;
        }
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);
        return  Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun Article avec le code = " + codeArticle + " n'a été trouver dans la bdd",
                        ErrorCodes.ARTICLE_NOT_FOUND
                )
                );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null ){
            log.error("Article id est null");
            return ;
        }
        articleRepository.deleteById(id);
    }
}
