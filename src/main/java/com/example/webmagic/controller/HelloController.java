package com.example.webmagic.controller;

import com.example.webmagic.entity.VO.ArticleVO;
import com.example.webmagic.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author czWang
 * @Created 2018/12/4 10:35.
 */
@Controller
public class HelloController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "index")
    public String index(Model model){
        List<ArticleVO> articles = articleService.selectList(1);
        int pages = articleService.selectListPage();
        model.addAttribute("test","everybody");
        model.addAttribute("articles",articles);
        model.addAttribute("pageNum",1);
        model.addAttribute("pages",pages);
        return "blog.html";
    }

    @RequestMapping(value = "article/{pageNum}")
    public String index(Model model,@PathVariable Integer pageNum){
        List<ArticleVO> articles = articleService.selectList(pageNum);
        int pages = articleService.selectListPage();
        model.addAttribute("articles",articles);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pages",pages);
        return "blog.html";
    }

    @ResponseBody
    @RequestMapping(value = "article/hide/{id}")
    public String hide(@PathVariable Integer id){
        int delete = articleService.delete(id);
        if (delete > 0){
            return "success";
        }
        return "false";
    }
}
