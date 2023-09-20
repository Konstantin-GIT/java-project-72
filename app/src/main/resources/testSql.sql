SELECT
    u.id,
    u.name,
    uc.status_code,
    uc.created_at
FROM
    urls u
LEFT JOIN (
    SELECT
        uc.url_id,
        uc.status_code,
        uc.created_at
    FROM
        urlCheck uc
    WHERE
        (uc.url_id, uc.id) IN (
            SELECT
                url_id,
                MAX(id)
            FROM
                urlCheck
            GROUP BY
                url_id
        )
) uc ON u.id = uc.url_id;