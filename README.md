# mail_merge_application
[![codecov](https://codecov.io/gh/shakasu/mail_merge_application/branch/master/graph/badge.svg)](https://codecov.io/gh/shakasu/mail_merge_application)
[![Build Status](https://travis-ci.org/shakasu/mail_merge_application.svg?branch=master)](https://travis-ci.org/shakasu/mail_merge_application)
 
 Приложение для слияния пользователей с одинаковым email.
 
 Считается, что если у двух пользователей есть общий email, значит это
 один и тот же пользователь. Данное приложение реализует алгоритм, выполняющий слияние пользователей. На выходе
 будет список пользователей с их email-ами.
 
 Для корректной работы необходимо составить *.txt файл со следующим синтаксисом:
 имя пользователя, далее разделитель "->", далее почтовые адреса через запятую, желательно без пробелов.
 
 Например:
 
 user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru
 
 user2 ->foo@gmail.com,ups@pisem.net
 
 user3 ->xyz@pisem.net,vasya@pupkin.com
 
 user4 ->ups@pisem.net,aaa@bbb.ru
 
 user5 ->xyz@pisem.net
 
 Возможный ответ на задачу в указанном примере:
 
 user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru,ups@pisem.net,aaa@bbb.ru
 
 user3 ->xyz@pisem.net,vasya@pupkin.com
 
 Для запуска необходимо скачать файл app из папки target.
 Вызвать командную строку и "java -jar app.jar". 

Формат ввода для поиска исходного списка пользователей: "./src/main/resources/list_of_users.txt"
