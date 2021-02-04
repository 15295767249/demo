package cn.com.yhb.controller;

import cn.com.yhb.model.PantoneColor;
import cn.com.yhb.service.PantoneColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/pantone", produces = MediaType.APPLICATION_JSON_VALUE)
public class PantoneColorController {

    @Value("${file.html}")
    private String FILE_HTML;

    @Autowired
    PantoneColorService pantoneColorService;

    @PostMapping(value = "/add")
    public boolean add() {
        return pantoneColorService.add(FILE_HTML);
    }

    @GetMapping(value = "/colos")
    public List<Map<String, List<PantoneColor>>> colors() {
        return pantoneColorService.findPantoneColors();
    }
}
