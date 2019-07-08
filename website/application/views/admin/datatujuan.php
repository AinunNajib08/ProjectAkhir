<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
    <meta name="author" content="Creative Tim">
    <title>Data Tujuan Pelayanan</title>
    <!-- Favicon -->
    <link href="<?= base_url('assets/img/brand/icon.png'); ?>" rel="icon" type="image/png">
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <!-- Icons -->
    <link href="<?= base_url('assets/vendor/nucleo/css/nucleo.css'); ?>" rel="stylesheet">
    <link href="<?= base_url('assets/vendor/@fortawesome/fontawesome-free/css/all.min.css'); ?>" rel="stylesheet">
    <!-- Argon CSS -->
    <link type="text/css" href="<?= base_url('assets/css/argon.css?v=1.0.0'); ?>" rel="stylesheet">
</head>

<body>
    <!-- Sidenav -->
    <nav class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-white" id="sidenav-main">
        <div class="container-fluid">
            <!-- Toggler -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- Brand -->
            <a class="navbar-brand pt-0 text-primary" href="../index.html">
                <h2>Klinik Husada-Mulia</h2>
            </a>
            <!-- User -->
            <ul class="nav align-items-center d-md-none">
                <li class="nav-item dropdown">
                    <a class="nav-link nav-link-icon" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="ni ni-bell-55"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right" aria-labelledby="navbar-default_dropdown_1">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <div class="media align-items-center">
                            <span class="avatar avatar-sm rounded-circle">
                                <img alt="Image placeholder" src="<?= base_url('assets/img/theme/team-1-800x800.jpg'); ?>">
                            </span>
                        </div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
                        <div class=" dropdown-header noti-title">
                            <h6 class="text-overflow m-0">Welcome!</h6>
                        </div>
                        <a href="../examples/profile.html" class="dropdown-item">
                            <i class="ni ni-single-02"></i>
                            <span>My profile</span>
                        </a>
                        <a href="../examples/profile.html" class="dropdown-item">
                            <i class="ni ni-settings-gear-65"></i>
                            <span>Settings</span>
                        </a>
                        <a href="../examples/profile.html" class="dropdown-item">
                            <i class="ni ni-calendar-grid-58"></i>
                            <span>Activity</span>
                        </a>
                        <a href="../examples/profile.html" class="dropdown-item">
                            <i class="ni ni-support-16"></i>
                            <span>Support</span>
                        </a>
                        <div class="dropdown-divider"></div>
                        <a href="#!" class="dropdown-item">
                            <i class="ni ni-user-run"></i>
                            <span>Logout</span>
                        </a>
                    </div>
                </li>
            </ul>
            <!-- Collapse -->
            <div class="collapse navbar-collapse" id="sidenav-collapse-main">
                <!-- Collapse header -->
                <div class="navbar-collapse-header d-md-none">
                    <div class="row">
                        <div class="col-6 collapse-brand">
                            <a href="../index.html">
                                <img src="<?= base_url('assets/img/brand/blue.png'); ?>">
                            </a>
                        </div>
                        <div class="col-6 collapse-close">
                            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle sidenav">
                                <span></span>
                                <span></span>
                            </button>
                        </div>
                    </div>
                </div>
                <!-- Form -->
                <form class="mt-4 mb-3 d-md-none">
                    <div class="input-group input-group-rounded input-group-merge">
                        <input type="search" class="form-control form-control-rounded form-control-prepended" placeholder="Search" aria-label="Search">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <span class="fa fa-search"></span>
                            </div>
                        </div>
                    </div>
                </form>
                <!-- Navigation -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="../admin/datapasien">
                            <i class="ni ni-tv-2 text-primary"></i> View Data Pasien
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../admin/datakunjungan">
                            <i class="ni ni-bullet-list-67 text-blue"></i> View Data Kunjungan Pasien
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../admin/datapoli">
                            <i class="ni ni-shop text-orange"></i> View Poliklinik
                        </a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="../admin/datatujuan">
                            <i class="ni ni-single-02 text-yellow"></i> View Tujuan Pelayanan
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="../examples/tables.html">
                            <i class="ni ni-bullet-list-67 text-red"></i>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../examples/login.html">
                            <i class="ni ni-key-25 text-info"></i>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../examples/register.html">
                            <i class="ni ni-circle-08 text-pink"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="main-content">
    <!-- Top navbar -->
    <nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
      <div class="container-fluid">
        <!-- Brand -->
        <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="../index.html">Tujuan Pelayanan</a>
        <!-- Form -->
        <form class="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto">
          <div class="form-group mb-0">
            <div class="input-group input-group-alternative">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-search"></i></span>
              </div>
              <input class="form-control" placeholder="Search" type="text">
            </div>
          </div>
        </form>
        <!-- User -->
        <ul class="navbar-nav align-items-center d-none d-md-flex">
          <li class="nav-item dropdown">
            <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <div class="media align-items-center">
                <span class="avatar avatar-sm rounded-circle">
                  <img alt="Image placeholder" src="<?= base_url('assets/img/brand/usericon.png'); ?>">
                </span>
                <div class="media-body ml-2 d-none d-lg-block">
                  <span class="mb-0 text-sm  font-weight-bold"><?= $this->session->userdata('username'); ?></span>
                </div>
              </div>
            </a>
            <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
              <div class=" dropdown-header noti-title">
                <h6 class="text-overflow m-0">Selamat Datang!</h6>
              </div>
              <div class="dropdown-divider"></div>
              <a href="<?= base_url('login_controler/logout'); ?>" class="dropdown-item">
                <i class="ni ni-user-run"></i>
                <span>Logout</span>
              </a>
            </div>
          </li>
        </ul>
      </div>
    </nav>
    <!-- Header -->
    <div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
            <div class="container-fluid">
                <div class="header-body">
                    <!-- Card stats -->
                    <div class="row">
                        <div class="col-xl-3 col-lg-6">
                            <div class="card card-stats mb-4 mb-xl-0">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col">
                                            <h5 class="card-title text-uppercase text-muted mb-0">Data Tujuan Pelayanan</h5>
                                            <span class="h2 font-weight-bold mb-0"><?php echo $count; ?></span>
                                        </div>
                                        <div class="col-auto">
                                            <div class="icon icon-shape bg-danger text-white rounded-circle shadow">
                                                <i class="fas fa-chart-bar"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-6">
                            <div class="card card-stats mb-4 mb-xl-0">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col">
                                            <h5 class="card-title text-uppercase text-muted mb-0"></h5>
                                            <span class="h2 font-weight-bold mb-0"></span>
                                        </div>
                                        <div class="col-auto">
                                            <div class="icon icon-shape bg-warning text-white rounded-circle shadow">
                                                <i class="fas fa-chart-pie"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-6">
                            <div class="card card-stats mb-4 mb-xl-0">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col">
                                            <h5 class="card-title text-uppercase text-muted mb-0"></h5>
                                            <span class="h2 font-weight-bold mb-0"></span>
                                        </div>
                                        <div class="col-auto">
                                            <div class="icon icon-shape bg-yellow text-white rounded-circle shadow">
                                                <i class="fas fa-users"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-6">
                            <div class="card card-stats mb-4 mb-xl-0">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col">
                                            <h5 class="card-title text-uppercase text-muted mb-0"></h5>
                                            <span class="h2 font-weight-bold mb-0"></span>
                                        </div>
                                        <div class="col-auto">
                                            <div class="icon icon-shape bg-info text-white rounded-circle shadow">
                                                <i class="fas fa-percent"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            <!-- Table -->
            <!-- Dark table -->
            <br>
            <br>
            <div class="row mt-5">
              <div class="col">
                <div class="card bg-default shadow">
                  <div class="card-header bg-transparent border-0">
                    <h3 class="text-white mb-0">Tabel Tujuan Pelayanan</h3>
                  </div>
                  <div class="table-responsive">
                    <table class="table align-items-center table-dark table-flush">
                      <thead class="thead-dark">
                        <tr>
                          <th scope="col">Kode Tujuan</th>
                          <th scope="col">Tujuan Pelayanan</th>
                          <th scope="col">Nama Poli Tujuan</th>
                        </tr>
                        <?php foreach ($tujuan_pelayanan as $tujuan_pelayanan) : ?>
                          <tr>
                            <td><?php echo $tujuan_pelayanan->kode_tujuan ?></td>
                            <td><?php echo $tujuan_pelayanan->tujuan_pelayanan ?></td>
                            <td><?php echo $tujuan_pelayanan->poli ?></td>
                          </tr>
                        <?php endforeach; ?>
                      </thead>
                      <tbody>
                        <tr>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</body>
<!-- Footer -->
<footer class="sticky-footer bg-white mt-3">
  <div class="container my-auto">
    <div class="copyright text-center my-auto">
      <span>Copyright &copy; The Hoax Team 2019</span>
    </div>
  </div>
</footer>
<!-- End of Footer -->

<!-- Argon Scripts -->
<!-- Core -->
<script src="<?= base_url('assets/vendor/jquery/dist/jquery.min.js'); ?>"></script>
<script src="<?= base_url('assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js'); ?>"></script>
<!-- Argon JS -->
<script src="<?= base_url('assets/js/argon.js?v=1.0.0'); ?>"></script>


</html>