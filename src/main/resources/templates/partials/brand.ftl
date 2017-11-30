<style>
	.navbar-brand > small {
		color: #ce93d8 !important;
		font-size: 80%;
	}
    .lv_logo{
        background-image:url('images/logo.jpg');
        background-repeat:no-repeat;
        background-size: contain;
        display:block;
        height:45px;
        width:45px;
        text-align:center;
        margin: 0 auto;
        /*margin-bottom:25px*/
    }
</style>
<script src="/libs/jquery/dist/jquery.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('.navbar-brand').on("click",function() {
            window.location.href = "/builds";
		});
    });
</script>
<a href="#" class="navbar-brand">
	<!-- <div data-ui-include="'images/logo.jpg'"></div>
	<img src="images/logo.png" alt="." class="hide">
	<span class="hidden-folded inline">klov</span> -->
	<#--<small class="dk _600 text-sm">klov.</small>-->
    <small class="dk _600 text-sm lv_logo"></small>
</a>