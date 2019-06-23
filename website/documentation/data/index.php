<?php

require __DIR__ . '/vendor/autoload.php';
require __DIR__ . '/api/v1/utils/config.php';

/*
REGISTER
*/
include __DIR__ . '/api/v1/models/M_kunjungan.php';
include __DIR__ . '/api/v1/models/M_user.php';
include __DIR__ . '/api/v1/models/M_login.php';
include __DIR__ . '/api/v1/controller/user.php';

$app->run();
