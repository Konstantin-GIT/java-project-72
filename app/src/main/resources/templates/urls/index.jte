@import hexlet.code.dto.UrlsPage
@import hexlet.code.model.UrlCheck
@import java.util.Map
@param UrlsPage urlsPage
<!--@param String successMessage -->

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Анализатор страниц</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>

<body class="d-flex flex-column min-vh-100">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Анализатор страниц</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <div class="navbar-nav">
                <a class="nav-link" href="/">Главная</a>
                <a class="nav-link" href="/urls">Сайты</a>
            </div>
        </div>
    </div>
</nav>

<main class="flex-grow-1">
    @if (urlsPage.getFlashType().equals("success"))
        <div class="rounded-0 m-0 alert alert-dismissible fade show alert alert-success" role="alert" >
            ${urlsPage.getFlash()}
        </div>
    @endif
    @if (urlsPage.getFlashType().equals("danger"))
        <div class="rounded-0 m-0 alert alert-dismissible fade show alert-danger" role="alert" >
            ${urlsPage.getFlash()}
        </div>
    @endif
    <section>
        <div class="container-lg mt-5">
            <h1>Сайты</h1>
            <table class="table table-bordered table-hover mt-3">
                <thead>
                <tr>
                    <th class="col-1">ID</th>
                    <th>Имя</th>
                    <th class="col-2">Последняя проверка</th>
                    <th class="col-1">Код ответа</th>
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

            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center mt-5">
                    <li class="page-item disabled">
                        <a class="page-link" href="/urls?page=0">Previous</a>
                    </li>
                    <li class="page-item active">
                        <a class="page-link" href="/urls?page=1">1</a>
                    </li>
                    <li class="page-item disabled">
                        <a class="page-link" href="/urls?page=2">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
    </section>
</main>

<footer class="footer border-top py-3 mt-5 bg-light">
    <div class="container-xl">
        <div class="text-center">
            created by
            <a href="https://ru.hexlet.io" target="_blank">Hexlet</a>
        </div>
    </div>
</footer>
</body>

</html>