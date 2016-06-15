<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="">
<meta name="author" content="CDAP">
<meta name="keyword" content="ML">
<link rel="shortcut icon" href="backend_resources/img/favicon.html">

<title>Machine Learner</title>


<script>
	//owl carousel

	$(document).ready(function() {
		$("#owl-demo").owlCarousel({
			navigation : true,
			slideSpeed : 300,
			paginationSpeed : 400,
			singleItem : true,
			autoPlay : true

		});

	});

	//custom select box

	$(function() {
		$('select.styled').customSelect();
	});

	function getResult() {

		var streamingUrl = $('#streamingUrl').val();

		$.ajax({
			type : "POST",
			url : 'DashboardController',
			data : "streamingUrl=" + streamingUrl,
			success : function(msg) {
				$('#result_content').show();
				$('#result').val(msg);
			}
		});
	}
	
	function create(){
		window.location.href = "http://localhost:8080/MLweb/allDataset.jsp";
	}
</script>

<!-- Bootstrap core CSS -->
<link href="backend_resources/css/bootstrap.min.css" rel="stylesheet">
<link href="backend_resources/css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="backend_resources/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link
	href="backend_resources/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="backend_resources/css/owl.carousel.css"
	type="text/css">

<!--dynamic table-->
<link
	href="backend_resources/assets/advanced-datatable/media/css/demo_page.css"
	rel="stylesheet" />
<link
	href="backend_resources/assets/advanced-datatable/media/css/demo_table.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="backend_resources/assets/data-tables/DT_bootstrap.css" />

<!--right slidebar-->
<link href="backend_resources/css/slidebars.css" rel="stylesheet">

<!--toastr-->
<link href="backend_resources/assets/toastr-master/toastr.css"
	rel="stylesheet" type="text/css" />

<!-- Custom styles for this template -->

<link href="backend_resources/css/style.css" rel="stylesheet">
<link href="backend_resources/css/style-responsive.css" rel="stylesheet" />
<link
	href="backend_resources/assets/jquery-ui/jquery-ui-1.10.1.custom.min.css"
	rel="stylesheet" />
<link
	href="backend_resources/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.css"
	rel="stylesheet">

<script src="backend_resources/js/jquery.js"></script>
<script src="backend_resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="backend_resources/js/jquery.validate.min.js"></script>




<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
          <script src="backend_resources/js/html5shiv.js"></script>
          <script src="backend_resources/js/respond.min.js"></script>
        <![endif]-->
</head>

<body>

	<section id="container"> <!--header start--> <header
		class="header white-bg">
	<div class="sidebar-toggle-box">
		
	</div>
	<!--logo start--> <a href="index.jsp" class="logo"><img
		src="uploads/logo.png" style="width: 1495px;margin-left: -17px;height: 72px;margin-top: -16px;"></a> <!--logo end-->

	<div class="top-nav ">
		<!--search & user info start-->
		<ul class="nav pull-right top-menu">
			<li><input type="text" class="form-control search"
				placeholder="Search"></li>
			<!-- user login dropdown start-->
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#"> <img height="30" width="30"
					src="uploads/admin.jpg"> <span class="username">Admin</span>
					<b class="caret"></b>
			</a>
				<ul class="dropdown-menu extended logout">
					<div class="log-arrow-up"></div>
					<!-- <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
					<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
					<li><a href="#"><i class="fa fa-bell-o"></i> Notification</a></li> -->
					<li><a href="#"><i class="fa fa-key"></i> Log Out</a></li>
				</ul></li>
			
			<!-- user login dropdown end -->
		</ul>
		<!--search & user info end-->
	</div>
	<a href="index.jsp" class="logo"><img
		src="uploads/Header.PNG" style="width: 1497px;margin-left: -94px;height: 58px;margin-top: 46px;"></a>
	</header> <!--header end--> <!--main content start--> <section id="main-content">
	<section class="wrapper"> <!-- CONTENT -->

	<div class="row">
		<div class="col-sm-12">
			<section class="panel" style="margin-left:-212px;height: 630px;margin-top: 67px;"> 
			
			<form id="create-dataset-form" method="POST" enctype="multipart/form-data">
			<div class="row" style="margin-left: 383px;margin-right: 420px;">
			<h2>Create Dataset</h2>
			<hr>
				<div class="form-group">
					<label for="name">Dataset Name : <span
						class="mandatory">*</span></label> <input id="streamingUrl"
						name="streamingUrl" class="form-control" type="text"
						placeholder="Enter Dataset Name">
				</div>
				<div class="form-group">
					<label for="name">Description : <span
						class="mandatory">*</span></label> <textarea id="streamingUrl"
						name="streamingUrl" class="form-control" type="text"
						placeholder="Enter Description"></textarea>
				</div>
				<div class="form-group">
					<label for="name">URL : <span
						class="mandatory">*</span></label> <input id="streamingUrl"
						name="streamingUrl" class="form-control" type="text"
						placeholder="Enter Streaming URL">
				</div>
				<button type="button" class="btn btn-main" style="background: rgb(108, 92, 118);color: white;" onClick=create()>Create Dataset</button>
			</div>
			</form>
			
			</section>
		</div>
	</div>

	<!-- END CONTENT --> </section> </section> <!--main content end--> <!--footer end--> </section>
	<script>
		
	</script>
	<!-- js placed at the end of the document so the pages load faster -->

	<script src="backend_resources/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script class="include" type="text/javascript"
		src="backend_resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="backend_resources/js/jquery.scrollTo.min.js"></script>
	<script src="backend_resources/js/jquery.nicescroll.js"
		type="text/javascript"></script>

	<!--custom checkbox & radio-->
	<script type="text/javascript" src="backend_resources/js/ga.js"></script>

	<script type="text/javascript" language="javascript"
		src="backend_resources/assets/advanced-datatable/media/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="backend_resources/assets/data-tables/DT_bootstrap.js"></script>
	<script src="backend_resources/js/jquery.sparkline.js"
		type="text/javascript"></script>
	<script
		src="backend_resources/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
	<script src="backend_resources/js/owl.carousel.js"></script>
	<script src="backend_resources/js/jquery.customSelect.min.js"></script>
	<script src="backend_resources/js/respond.min.js"></script>

	<!--right slidebar-->
	<script src="backend_resources/js/slidebars.min.js"></script>

	<!--dynamic table initialization -->
	<script src="backend_resources/js/dynamic_table_init.js"></script>



	<!--common script for all pages-->
	<script src="backend_resources/js/common-scripts.js"></script>

	<!--script for this page-->
	<script src="backend_resources/js/form-validation-script.js"></script>


	<!--script for this page-->
	<script src="backend_resources/js/sparkline-chart.js"></script>
	<script src="backend_resources/js/easy-pie-chart.js"></script>
	<script src="backend_resources/js/count.js"></script>
	<script src="backend_resources/js/form-component.js"></script>




</body>

</html>
