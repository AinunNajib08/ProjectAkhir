<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
    <meta name="author" content="Creative Tim">
    <title>Data Pasien</title>
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
                        <a href="<?= base_url('login_controler/logout'); ?>" class="dropdown-item">
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
                        <a class="nav-link" href="../datapasien">
                            <i class="ni ni-tv-2 text-primary"></i> View Data Pasien
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../datakunjungan">
                            <i class="ni ni-bullet-list-67 text-blue"></i> View Data Kunjungan Pasien
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../datapoli">
                            <i class="ni ni-shop text-orange"></i> View Poliklinik
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../datatujuan">
                            <i class="ni ni-single-02 text-yellow"></i> View Tujuan Pelayanan
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Main content -->
    <div class="main-content">
        <!-- Top navbar -->
        <nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
            <div class="container-fluid">
                <!-- Brand -->
                <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="../index.html"></a>
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

                    <!-- End of Topbar -->

                    <!-- Start Container Fluid -->

                    <div id="content-wrapper">

                        <div class="container-fluid">

                            <div class="card mb-3">
                                <div class="card-header">
                                </div>
                                <div class="card-body">

                                    <form action="<?php base_url('admin/datapasien/add') ?>" method="post" enctype="multipart/form-data">
                                        <div class="row">
                                            <div class="col-4">
                                                <div class="form-group">
                                                    <label for="no_rm">No Rekam Medik*</label>
                                                    <input class="form-control" type="text" name="no_rm" placeholder="No Rekam Medik" />
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-group">
                                                    <label for="no_al">No Asuransi Lainnya*</label>
                                                    <input class="form-control" type="text" name="no_al" placeholder="Nomor Asuransi Lainnya" />
                                                </div>
                                            </div>
                                            <div class=" col-4">
                                                <div class="form-group">
                                                    <label for="nama">Nama Pasien*</label>
                                                    <input class="form-control" type="text" name="nama" placeholder="Nama Pasien" />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-3">
                                                <div class="form-group">
                                                    <label for="usia">Usia*</label>
                                                    <input class="form-control" type="text" name="usia" placeholder="Usia" />
                                                </div>
                                            </div>
                                            <div class="col-3">
                                                <div class="form-group">
                                                    <label for="tgl_lahir">Tanggal Lahir*</label>
                                                    <input class="form-control" type="date" data-date-format="DD MMMM YYYY" data-date="" name="tgl_lahir" placeholder="Tanggal Lahir" />
                                                </div>
                                            </div>
                                            <div class="col-3">
                                                <div class="form-group">
                                                    <label for="jenis_kelamin">Jenis Kelamin*</label>
                                                    <input class="form-control" type="text" name="jenis_kelamin" placeholder="Jenis Kelamin" />
                                                </div>
                                            </div>
                                            <div class="col-3">
                                                <div class="form-group">
                                                    <label for="agama">Agama*</label>
                                                    <input class="form-control" type="text" name="agama" placeholder="Agama" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-3">
                                                <div class="form-group">
                                                    <label for="alamat">Alamat*</label>
                                                    <input class="form-control" type="text" name="alamat" placeholder="alamat" />
                                                </div>
                                            </div>
                                            <div class="col-3">
                                                <div class="form-group">
                                                    <label for="kota">Kota*</label>
                                                    <input class="form-control" type="text" name="kota" placeholder="Kota" />
                                                </div>
                                            </div>
                                            <div class="col-3">
                                                <div class="form-group">
                                                    <label for="provinsi">Provinsi*</label>
                                                    <input class="form-control" type="text" name="provinsi" placeholder="Provinsi" />
                                                </div>
                                            </div>
                                            <div class="col-3">
                                                <div class="form-group">
                                                    <label for="telepon">Telepon*</label>
                                                    <input class="form-control" type="text" name="telepon" placeholder="Telepon" />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-4">
                                                <div class="form-group">
                                                    <label for="pekerjaan">Pekerjaan*</label>
                                                    <input class="form-control" type="text" name="pekerjaan" placeholder="Pekerjaan" />
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-group">
                                                    <label for="foto">Foto*</label>
                                                    <input class="form-control" type="file" name="foto" placeholder="Foto" />
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-group">
                                                    <label for="email">Email*</label>
                                                    <input class="form-control" type="email" name="email" placeholder="Email" />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-4">
                                                <div class="form-group">
                                                    <label for="org_tua">Orang Tua*</label>
                                                    <input class="form-control" type="text" name="org_tua" placeholder="Orang Tua" />
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-group">
                                                    <label for="status_kawin">Status Perkawinan*</label>
                                                    <input class="form-control" type="text" name="status_kawin" placeholder="Status Perkawinan" />
                                                </div>
                                            </div>
                                            <div class="col-4">
                                                <div class="form-group">
                                                    <label for="status_tinggal">Status Tinggal*</label>
                                                    <input class="form-control" type="text" name="status_tinggal" placeholder="Status Tinggal" />
                                                </div>
                                            </div>
                                        </div>



                                        <input class="btn btn-success" type="submit" name="btn" value="Save" />
                                        <br />
                                        <?php if ($this->session->flashdata('success')) : ?>
                                            <div class="alert alert-success" role="alert">
                                                <?php echo $this->session->flashdata('success'); ?>
                                            </div>
                                        <?php endif; ?>
                                    </form>

                                </div>


                            </div>
                            <!-- /.container-fluid -->

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white mt-3">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; The Hoax Team 2019</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="<?= base_url('assets/vendor/jquery/dist/jquery.min.js'); ?>"></script>
    <script src="<?= base_url('assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js'); ?>"></script>
    <!-- Argon JS -->
    <script src="<?= base_url('assets/js/argon.js?v=1.0.0'); ?>"></script>

</body>

</html>