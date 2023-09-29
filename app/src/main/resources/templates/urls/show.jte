@import hexlet.code.dto.UrlPage
@import hexlet.code.model.Url
@import hexlet.code.model.UrlCheck
@import java.util.List
@param UrlPage urlPage

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Информация о URL</title>
    <!-- Подключение CSS-файла Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
@if (urlPage.getFlashType().equals("success"))
    <div class="alert alert-success" role="alert">
        ${urlPage.getFlash()}
    </div>
@endif
@if (urlPage.getFlashType().equals("danger"))
    <div class="alert alert-success" role="alert">
        ${urlPage.getFlash()}
    </div>
@endif
<div class="container mt-5">
    <h1 class="display-4">Информация о URL</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">ID ${urlPage.getUrl().getId()}</h5>
            <p class="card-text">Имя ${urlPage.getUrl().getName()}</p>
            <p class="card-text">Дата создания ${urlPage.getUrl().getCreatedAt().toString()}</p>
        </div>
    </div>
    <form method="post" action="/urls/${urlPage.getUrl().getId()}/checks">
        <div class="form-group">
            <label for="inputField">Проверки</label>
        </div>
        <button type="submit" class="btn btn-success btn-block">Запустить проверку</button>
    </form>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Код ответа</th>
            <th>title</th>
            <th>h1</th>
            <th>description</th>
            <th>Дата проверки</th>
        </tr>
        </thead>
        <tbody>
        @for (UrlCheck urlCheck : urlPage.getChecks())
            <tr>
                <td>${urlCheck.getId()}</td>
                <td>${urlCheck.getStatusCode()}</td>
                <td>${urlCheck.getTitle()}</td>
                <td>${urlCheck.getH1()}</td>
                <td>${urlCheck.getDescription()}</td>
                <td>${urlCheck.getCreatedAt().toString()}</td>
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
