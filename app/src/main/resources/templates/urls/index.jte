@import hexlet.code.dto.UrlsPage
@import hexlet.code.model.UrlCheck
@import java.util.Map
@param UrlsPage urlsPage
<!--@param String successMessage -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список URL</title>
    <!-- Подключение CSS-файла Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
@if (urlsPage.getFlashType().equals("success"))
    <div class="alert alert-success" role="alert">
        ${urlsPage.getFlash()}
    </div>
@endif
@if (urlsPage.getFlashType().equals("danger"))
    <div class="alert alert-success" role="alert">
        ${urlsPage.getFlash()}
    </div>
@endif
<div class="container mt-5">
    <h1 class="display-4">Список URL</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Последняя проверка</th>
            <th>Код ответа</th>
        </tr>
        </thead>
        <tbody>
        @for(var url : urlsPage.getUrls())
        <tr>
            <td>${url.getId()}</td>
            <td>
                <a href="/urls/${url.getId()}">${url.getName()}</a>
            </td>
            <td>${urlsPage.getUrlChecks().isEmpty() || urlsPage.getUrlChecks().get(url.getId()) == null  ? "" : urlsPage.getUrlChecks().get(url.getId()).getCreatedAt().toString()}</td>
            <td>${urlsPage.getUrlChecks().isEmpty() || urlsPage.getUrlChecks().get(url.getId()) == null ? "" : urlsPage.getUrlChecks().get(url.getId()).getStatusCode().toString()}</td>
        </tr>
        @endfor
        </tbody>
    </table>
</div>
<!-- Подключение JS-файлов Bootstrap (jQuery и Popper.js) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
