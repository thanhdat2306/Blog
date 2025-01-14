package com.example.demo.springbootdeveloper.controller;

import com.example.demo.springbootdeveloper.domain.Article;
import com.example.demo.springbootdeveloper.dto.AddArticleRequest;
import com.example.demo.springbootdeveloper.dto.ArticleResponse;
import com.example.demo.springbootdeveloper.dto.UpdateArticleRequest;
import com.example.demo.springbootdeveloper.repository.BlogRepository;
import com.example.demo.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    // Khi phương thức HTTP là POST, nếu nó giống với URL nhận được thì nó sẽ được ánh xạ tới phương thức đó.
    @PostMapping("/api/articles")
    // Yêu cầu ánh xạ giá trị nội dung
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request, Principal principal) {
        Article savedArticle = blogService.save(request, principal.getName());
        // Tài nguyên được yêu cầu đã được tạo thành công và thông tin bài đăng blog đã lưu đã được gửi trong đối tượng phản hồi.
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    // Trích xuất giá trị từ đường dẫn URL
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article updateArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updateArticle);
    }
}
