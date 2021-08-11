INSERT INTO tb_usuario(user_name,password) 
VALUES
('admin@email.com','$2a$10$G3D6CJJEfqsoj5Px5zCi7uUjSPFe3RCFYAjZEYz3kDAxTrWsNn9Ri');

insert into public.tb_categoria(titulo,cor)
values ('Livre','grey'),
('Front-End','green'),
('Back-End','purple'),
('DevOps','red');

insert into public.tb_video (titulo, descricao, url, categoria_id)
values 
('O que é REST?','O que é rest','https://www.youtube.com/watch?v=weQ8ssA6iBU',1),
('Final Fantasy','FFVII','https://www.youtube.com/watch?v=I_ATSCTnUD8',1),
('Assassins Creed','Assassins Creed','https://www.youtube.com/watch?v=KDfdjB9uL0U',1),
('Fetiço do Tempo','Fetiço','https://www.youtube.com/watch?v=zi8d69P9NvI',1),
('Alura Cases','curioso pra assistir','https://www.youtube.com/watch?v=Amt8gqUCHB8',1),
('Componentes com VanillaJS','VanillaJS','https://www.youtube.com/watch?v=LatCKpcOMak',2),
('Novidades Angular','Angular','https://www.youtube.com/watch?v=34uHo7hFmG0',2),
('Kafka','kafka','https://www.youtube.com/watch?v=G6Tcy7hNdA8',4),
('Docker','Docker','https://www.youtube.com/watch?v=95D90nRsDB8',4),
('O que é DevOps','DevOps','https://www.youtube.com/watch?v=3_k2GVkMt30',4),
('Microserviços','o que sao de onde vem e o que comem','https://www.youtube.com/watch?v=jSnLOoGjQ80',4),
('Emuladores','sempre curti','https://www.youtube.com/watch?v=9qx7qjKhJ1Q',2),
('Melhor Linguagem','Qual é a melhor linguagem de programação?','https://www.youtube.com/watch?v=Uh-GNH-t89w',3),
('Estrutura de Daddos','dados','https://www.youtube.com/watch?v=UOK7nS2E9xM',3),
('Git for dummies','git','https://www.youtube.com/watch?v=6OokP-NE49k',3),
('Dicionario do programador','dicionario','https://www.youtube.com/watch?v=vGuqKIRWosk',3),
('Gatacca','Gatacca','https://www.youtube.com/watch?v=Dl0tYLbrhhs',1),
('Interestellar','Interestellar','https://www.youtube.com/watch?v=frD_IiY_A3E',1),
('Display inliner','Pare de chutar e aprenda a display: inliner','https://www.youtube.com/watch?v=5PS6ku8NzIE',2);