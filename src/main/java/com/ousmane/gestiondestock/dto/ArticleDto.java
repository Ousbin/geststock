package com.ousmane.gestiondestock.dto;

import com.ousmane.gestiondestock.model.Article;
import com.ousmane.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategoryDto category;

    public static ArticleDto fromEntity(Article article){
        if (article == null){
            return null;
        }

        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .build();
    }

    public static Article toEntity(ArticleDto articleDto){
        if(articleDto == null){
            return null;
        }

        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(article.getCodeArticle());
        article.setDesignation(article.getDesignation());
        article.setPrixUnitaireHt(article.getPrixUnitaireHt());
        article.setTauxTva(article.getTauxTva());
        article.setPrixUnitaireTtc(article.getPrixUnitaireTtc());
        article.setPhoto(article.getPhoto());
        return article;
    }
}
