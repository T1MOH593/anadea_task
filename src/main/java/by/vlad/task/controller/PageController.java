package by.vlad.task.controller;

import by.vlad.task.entity.Page;
import by.vlad.task.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private PageService pageService;

    @GetMapping("/menu")
    public String showMenu(Model model) {
        var publishedPages = pageService.getPublishedPages();
        var unpublishedPages = pageService.getUnpublishedPages();
        publishedPages.sort((p1, p2) -> p2.getPriority() - p1.getPriority());
        model.addAttribute("publishedPages", publishedPages);
        model.addAttribute("unpublishedPages", unpublishedPages);
        return "menu";
    }

    @GetMapping("/pages")
    public String showAddNewPage() {
        return "newPage";
    }

    @PostMapping("/pages")
    public String savePage(@RequestParam("title") String title,
                           @RequestParam("description") String description,
                           @RequestParam("slug") String slug,
                           @RequestParam("h1") String h1,
                           @RequestParam("content") String content,
                           @RequestParam("publishedAt") String publishedAt,
                           @RequestParam("priority") Integer priority) {
        var page = new Page();

        page.setTitle(title);
        page.setDescription(description);
        page.setSlug(slug);
        page.setMenuLabel("/pages/" + slug);
        page.setH1(h1);
        page.setContent(content);
        page.setPublishedAt(LocalDateTime.parse(publishedAt + ":00"));
        page.setPriority(priority);

        pageService.savePage(page);
        return "redirect:/menu";
    }

    @GetMapping("/pages/{slug}")
    public String showPage(@PathVariable("slug") String slug,
                           Model model) {
        var maybePage = pageService.getPage(slug);
        if (maybePage.isPresent()) {
            model.addAttribute("page", maybePage.get());
            return "page";
        } else {
            return "redirect:/menu";
        }
    }

    @GetMapping("/pages/edit/{slug}")
    public String editPage(@PathVariable("slug") String slug,
                           Model model) {
        var maybePage = pageService.getPage(slug);
        if (maybePage.isPresent()) {
            var page = maybePage.get();
            page.setContent(page.getContent()
                    .replaceAll("&", "&amp;")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("\"", "&quot;"));
            model.addAttribute("page", maybePage.get());
            return "editPage";
        } else {
            return "redirect:/menu";
        }
    }

    @PostMapping("/pages/edit/{slug}")
    public String editPage(@RequestParam("title") String title,
                           @RequestParam("description") String description,
                           @RequestParam("h1") String h1,
                           @RequestParam("content") String content,
                           @RequestParam("publishedAt") String publishedAt,
                           @RequestParam("priority") Integer priority,
                           @PathVariable("slug") String slug) {
        var newPage = new Page();
        newPage.setTitle(title);
        newPage.setDescription(description);
        newPage.setH1(h1);
        newPage.setContent(content
                .replaceAll("&amp;", "&")
                .replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">")
                .replaceAll("&quot;", "\""));
        newPage.setPublishedAt(LocalDateTime.parse(publishedAt + ":00"));
        newPage.setPriority(priority);
        newPage.setSlug(slug);
        newPage.setMenuLabel("/pages/" + slug);
        pageService.savePage(newPage);

        return "redirect:/menu";
    }

    @GetMapping("/pages/delete/{slug}")
    public String deletePage(@PathVariable("slug") String slug) {
        pageService.deletePage(slug);
        return "redirect:/menu";
    }
}

