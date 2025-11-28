package com.example.Rewaya.Controller;

import com.example.Rewaya.Api.ApiResponse;
import com.example.Rewaya.Model.Novel;
import com.example.Rewaya.Service.NovelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/rewaya/novel")
public class NovelController {

    private final NovelService novelService;

    @PostMapping("/publish")
    public ResponseEntity<?> createNovel(@RequestBody @Valid Novel novel, Errors errors) {
        if(errors.hasErrors()) return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        String result = novelService.createNovel(novel);
        if (result.equals("Published! :)"))
            return ResponseEntity.status(200).body(new ApiResponse(result));
        return ResponseEntity.status(400).body(new ApiResponse(result));
    }

    @GetMapping("/get")
    public List<Novel> getAll() { return novelService.getAll(); }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNovel(@PathVariable Integer id,@RequestBody @Valid Novel upd, Errors errors) {
        if(errors.hasErrors()) return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());


        String result = novelService.updateNovel(id, upd);
        if (result.equals("updated"))
            return ResponseEntity.status(200).body(new ApiResponse(result));
        return ResponseEntity.status(400).body(new ApiResponse(result));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
           if (novelService.deleteAuthor(id))
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("Novel not found"));
    }




    @PutMapping("/toggle like/{userId}/{novelId}")
    public ResponseEntity<?> toggleLike(@PathVariable Integer userId, @PathVariable Integer novelId) {

        String result = novelService.toggleLike(userId, novelId);
        if (result.equals("Liked :)") || result.equals("Like removed"))
            return ResponseEntity.status(200).body(new ApiResponse(result));
        return ResponseEntity.status(400).body(new ApiResponse(result));
    }

    @GetMapping("/my favorite Novels/{userId}")
    public List<Novel> getMyFavNovels(@PathVariable Integer userId) {
        return novelService.getMyFavNovels(userId);
    }

    @GetMapping("/completed")
    public List<Novel> getCompletedNov() {
        return novelService.getCompletedNov();
    }

    @GetMapping("/non completed")
    public List<Novel> getNonCompletedNov() {
        return novelService.getNonCompletedNov();
    }

    @PostMapping("/categories filter")
    public List<Novel> filterCategories(@RequestBody List<String> categories) {
        return novelService.filterCategories(categories);
    }

    @GetMapping("/top 3")
    public List<Novel> getTop3Novels() {
        return novelService.getTop3Novels();
    }

}

