<%--
  Created by IntelliJ IDEA.
  User: Bach
  Date: 3/7/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <a href="/customers">Danh sách sản phẩm</a>
    <h1>Cập nhật sản phẩm</h1>
    <form action="/customers?action=edit&id=${customer.id}" method="post">
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Tên KH:</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="name" value="${customer.name}" >
        </div>
        <div class="mb-3">
            <label for="country" class="form-label">Quốc Gia:</label>
            <input type="text" class="form-control" id="country" name="country" value="${customer.country}" >
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="text" class="form-control" id="email" name="email" value="${customer.email}" >
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
