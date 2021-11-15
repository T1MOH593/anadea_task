package by.vlad.task.service;

import by.vlad.task.dao.PageRepository;
import by.vlad.task.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    public List<Page> getPublishedPages() {
        var pages = pageRepository.findAll();
        pages = pages.stream()
                .filter(p -> p.getPublishedAt().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());
        return pages;
    }

    public List<Page> getUnpublishedPages() {
        var pages = pageRepository.findAll();
        pages = pages.stream()
                .filter(p -> p.getPublishedAt().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
        return pages;
    }

    public void savePage(Page page) {
        pageRepository.save(page);
    }

    public Optional<Page> getPage(String slug) {
        return pageRepository.findById(slug);
    }

    public void deletePage(String slug) {
        pageRepository.deleteById(slug);
    }
}
