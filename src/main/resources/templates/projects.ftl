<!DOCTYPE html>
<html lang="en" ng-app="Klov">
    <#include 'partials/head.ftl'>
    <style type="text/css">
        .select2, .select2-container--default .select2-selection--single {
        	/*background: #283593 !important;*/
            background: #333333 !important;
            border-color: rgb(255,255,255) !important;
            background-color: rgba(0, 0, 0, 0.2) !important;
            width:350px;
        }
        #single {
            width:350px;
            padding:20px;
            margin:0 auto;
        }
        .select2-selection__placeholder {
            color: #fff !important;
        }
        .select2-container--default .select2-selection--single .select2-selection__rendered {
        	color: #fff !important;
            width:350px;
        	line-height: 52px;
        }

        .select2-container .select2-selection--single {
        	height: 52px;
        }
        .select2-container--default .select2-selection--single .select2-selection__arrow {
            color: #fff !important;
        	height: 52px;
        }
        .lv_back {

            background-repeat:no-repeat;
            background-size: cover;
            background-position: center center;
            position: relative;
        }
        #lv_back1 {
            background-image: url('images/back1.jpg');
        }
        #lv_back2 {
            background-image: url('images/back2.jpg');
        }
        #lv_back3 {
            background-image: url('images/back3.jpg');
        }
        .indigo-800 {
            background-color: rgba(0, 0, 0, 0.5);
            color: rgba(255, 255, 255, 0.87);
        }
        .btn {
            background-color: rgba(0, 0, 0, 0.5);
            color: rgba(255, 255, 255, 0.87);
        }
        .lv_logo{
            background-image:url('images/logo.svg');
            background-repeat:no-repeat;
            display:block;
            height:64px;
            width:64px;
            text-align:center;
            margin: 0 auto;
            margin-bottom:25px
        }
    </style>
    <body>
        <div class="app" id="app">
        	<div id="content" class="app-content box-shadow-z2 bg pjax-container" role="main">
                <div class="app-header indigo-800 b-b">
                    <div class="navbar" data-pjax>
                        <a data-toggle="modal" data-target="#aside" class="navbar-item pull-left hidden-lg-up p-r m-a-0">
                        <i class="ion-navicon"></i>
                        </a>
                        <div class="navbar-item pull-left h6" id="pageTitle">Auto-test Monitor Center</div>
                    </div>
                </div>
            </div>
            <div class="indigo-800 h-v row-col">
                <div  <#if lvback??> id="${lvback}"<#else> id="lv_back2"</#if> class="lv_back row-cell v-m text-center animated fadeIn">
                        <form id="form" action="/assignProjectById" method="post">
                            <div class="lv_logo"></div>
                            <div style="margin-bottom: 25px"><h1>test center</h1></div>
                            <div class="form-group">
                                <select id="single" name="id" class="form-control select2 indigo-800" data-ui-jp="select2" data-ui-options="{theme: 'bootstrap'}">
                                    <option></option>
                                    <#list projectList as project>
                                    <option value="${project.id}">${project.name}</option>
                                    </#list>
                                </select>
                                <div class="m-t">
                                    <br/>
                                    <a href="#" class="btn btn-outline b-white rounded p-x-md" onclick="form.submit()">Go</a>
                                </div>
                            </div>
                        </form>
                </div>
            </div>
            <!-- ############ LAYOUT END-->
        </div>
        <#include 'partials/scripts.ftl'>
        <#include 'partials/angular.ftl'>
		<script>
			$(document).ready(function() {
			    $('#single').select2({
			    	placeholder: "Select your task"
			    });
			});
		</script>
    </body>
</html>