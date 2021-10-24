package hu.me.uni.iit.hw.sajat;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {
    private final int maxArticleNumber=10;
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public ArticleDto getById(Long id) {
        return articleRepository.getById(id);
    }

    @Override
    public Long save(ArticleDto articleDto) throws TooMuchArticleException {
        if(articleRepository.findAll().size() >= maxArticleNumber){
            throw new TooMuchArticleException();
        }

        return articleRepository.save(articleDto);
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }


}
