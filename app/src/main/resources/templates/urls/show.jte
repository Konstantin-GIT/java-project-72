@import hexlet.code.model.Url
@param Url url

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
<div class="container mt-5">
    <h1 class="display-4">Информация о URL</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">ID: ${url.getId()}</h5>
            <p class="card-text">Name: ${url.getName()}</p>
            <p class="card-text">Created At: ${url.getCreatedAt().toString()}</p>
        </div>
    </div>
    <button type="button" class="btn btn-primary">Запустить проверку</button>
</div>

<!-- Подключение JS-файлов Bootstrap (jQuery и Popper.js) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
