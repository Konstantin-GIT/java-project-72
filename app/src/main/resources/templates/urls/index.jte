@import hexlet.code.dto.UrlMainReport
@import java.util.List
@param List<UrlMainReport> urlsList
@param String successMessage

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
@if (!successMessage.isEmpty())
    <div class="alert alert-success" role="alert">
        ${successMessage}
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
        @for (UrlMainReport urlMainReport : urlsList)
        <tr>
            <td>${urlMainReport.getId()}</td>
            <td>
                <a href="/urls/${urlMainReport.getId()}">${urlMainReport.getName()}</a>
            </td>
            <td>${urlMainReport.getLastCheck() == null ? "" : urlMainReport.getLastCheck().toString()}</td>
            <td>${urlMainReport.getStatusCode()}</td>
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
