package me.jinmlee.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.jinmlee.springbootdeveloper.domain.Article;
import me.jinmlee.springbootdeveloper.dto.AddArticleRequest;
import me.jinmlee.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(Long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not fount: " + id));
    }
}
