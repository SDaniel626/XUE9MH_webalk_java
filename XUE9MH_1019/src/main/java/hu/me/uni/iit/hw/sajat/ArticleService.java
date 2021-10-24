package hu.me.uni.iit.hw.sajat;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> findAll();
    ArticleDto getById(Long id);
    Long save(ArticleDto articleDto) throws TooMuchArticleException;
    void deleteById(Long id);
}
