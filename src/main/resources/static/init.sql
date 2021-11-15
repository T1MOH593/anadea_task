create table if not exists public.pages (
    slug VARCHAR(10) PRIMARY KEY ,
    title VARCHAR(60) ,
    description VARCHAR(200) ,
    menu_label VARCHAR(100) ,
    h1 VARCHAR(200) ,
    content VARCHAR(2000) ,
    published_at TIMESTAMP ,
    priority INTEGER
);

INSERT INTO public.pages (slug, title, description, menu_label, h1, content, published_at, priority) VALUES
            ('page2', 'page2', 'page2', '/pages/page2', 'page2', '<h2>page2</h2>', '2021-11-15 20:59:19.000000', 5),
            ('page3', 'page3', 'page3', '/pages/page3', 'page3', '<h3>page3</h3>', '2021-11-05 21:00:02.000000', 3),
            ('page4', 'page4', 'page4', '/pages/page4', 'page4', '<h4>page4</h4>', '2021-11-20 21:00:41.000000', 6)