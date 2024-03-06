<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf" %>
<body>
	  <div class="row row-cols-1 row-cols-md-3 mb-3 text-center" id="item">
			<div class="col" id="item-template">
				<div class="card mb-4 rounded-3 shadow-sm border-primary">
					<div class="card-header py-3 text-bg-primary border-primary">
						<h4 class="my-0 fw-normal item-title"></h4><%-- 제목 --%>
					</div>
					<div class="card-body">
						<h5 class="card-title pricing-card-title">
							<span class="item-sigungu"></span>
							<small class="text-body-secondary fw-light item-adress"></small>
						</h5>
						<ul class="list-unstyled mt-3 mb-4">
							<li class="item-gov"></li>	
						</ul>
					</div>
				</div>
			</div>
		</div>
		<script>
			function template( sido_name, shel_nm, new_address, manage_gov_nm){
				let $div = $('#item');
				let $element = $('#item-template').clone().removeAttr('id');
				$element.find('.item-title').html(shel_nm);
				$element.find('.item-sigungu').html(sido_name);
				$element.find('.item-adress').html("/" + new_address);
				$element.find('.item-gov').html(manage_gov_nm);
				
				$div.append($element);
			}
			$(function(){
				const url = "/data/shelterList";
				$.getJSON(url, function(data) {
					$(data.shelterList.row).each(function(intex) {
						let sido_name = this.sido_name;
						let shel_nm = this.shel_nm;
						let new_address = this.new_address;
						let manage_gov_nm = this.manage_gov_nm;
						
						template(sido_name, shel_nm, new_address, manage_gov_nm);
					});
				}).fail(function(){
					alert("잠시후에 다시 시도해 주세요");
				});
			});
		</script>
</body>
</html>