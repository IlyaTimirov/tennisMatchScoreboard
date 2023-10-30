<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background-image: url('back.jpg');
            color: white;
        }
        header{
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: center;
        }
        .container, form{
            margin: auto;
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

        .table_dark {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif, serif;
            font-size: 14px;
            width: 640px;
            text-align: left;
            border-collapse: collapse;
            background: #252F48;
            margin: 10px;
        }
        .table_dark th {
            color: #EDB749;
            border-bottom: 1px solid #37B5A5;
            padding: 12px 17px;
        }
        .table_dark td {
            color: #CAD4D6;
            border-bottom: 1px solid #37B5A5;
            border-right:1px solid #37B5A5;
            padding: 7px 17px;
        }
        .table_dark tr:last-child td {
            border-bottom: none;
        }
        .table_dark td:last-child {
            border-right: none;
        }
        .table_dark tr:hover td {
            text-decoration: underline;
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
                <li><a href="home">Главная</a></li>
                <li><a href="new-match">Начать новый матч</a></li>
                <li><a href="matches">Завершеные матчи</a></li>
            </ul>
        </div>
    </div>
</header>
<div class="container">
    <table class="table_dark">
        <tr>
            <th>Имя первого игрока</th>
            <th>Имя второго игрока</th>
            <th>Выиграл</th>
        </tr>
        <tr>
            <td>${requestScope.player1.name}</td>
            <td>${requestScope.player2.name}</td>
            <c:if test="${requestScope.player1.id == requestScope.winner.id}" >
                <td>${requestScope.player1.name}</td>
            </c:if>
            <c:if test="${requestScope.player2.id == requestScope.winner.id}" >
                <td>${requestScope.player2.name}</td>
            </c:if>
        </tr>

    </table>
</div>

</body>
</html>
