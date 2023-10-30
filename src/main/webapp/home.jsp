<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Моя первая страница</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background-image: url('back.jpg');
            //background-repeat: no-repeat;
            //background-size: cover;
            color: white;
        }
        header{
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: center;
        }
        .logo, .top_menu{
            display: inline-block;
        }
        .top_menu li{
            display: inline-block;

        }
        a{
            display: block;
            width: 200px;
            height: 40px;
            line-height: 40px;
            font-size: 18px;
            font-family: sans-serif;
            text-decoration: none;
            color: olivedrab;
            border: 2px solid olivedrab;
            letter-spacing: 2px;
            text-align: center;
            transition: all .35s;
        }

        a:hover{
            color: white;
        }

        a:hover:after{
            width: 100%;
        }
    </style>
</head>
<body>
    <header>
        <div class="All_header_menu">
            <div class="logo">
                <h1>Hello World!</h1>
            </div>
            <div class="top_menu">
                <ul>
                    <li><a href="matches">Завершеные матчи</a></li>
                    <li><a href="new-match">Начать новый матч</a></li>
                </ul>
            </div>
        </div>
    </header>
</body>
</html>