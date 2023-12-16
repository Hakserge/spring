package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.Image;
import com.learnspring.learnspring.services.ImageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/file")
    public String index(Model model) {
        List<Image> images = imageService.getAllImages();
        model.addAttribute("images", images);
        return "file";
    }

    @PostMapping("/images")
    public String saveImage(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) throws IOException {
        byte[] data = file.getBytes();
        imageService.saveImage(name, data);
        return "redirect:/file";
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
        Optional<Image> image = imageService.getImageById(id);
        if (image.isPresent()) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image.get().getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}