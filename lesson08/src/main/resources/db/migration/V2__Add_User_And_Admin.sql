set search_path to sec;

insert into users (username, password, email, role)
values
('user', '$2y$12$EFgNamlZ08x/UXolq6ajreNjOMmDlwRqPWyr4iUUMKGJn/35GVoau', 'user@gmail.com', 'ADMIN');

insert into users (username, password, email, role)
values
('guest', '$2y$12$EFgNamlZ08x/UXolq6ajreNjOMmDlwRqPWyr4iUUMKGJn/35GVoau', 'guest@gmail.com', 'USER');