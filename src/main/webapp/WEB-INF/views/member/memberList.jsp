<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<form id="formList" name="formList" method="POST" action="/infra/member/memberList">
<input type="hidden" id="thisPage" name="thisPage" value="<c:out value="${vo.thisPage}" default="1"/>"> <!-- id, name 이름 안들어가면 에러는 안뜨는데 작동안함 , value="<c:out value="${vo.thisPage}" default="1"/>" 이거없어도 작동됨-->
<input type="hidden" id="ifmmSeq" name="ifmmSeq">

<c:choose>
	<c:when test="${fn:length(list) eq 0}">
		<tr>
			<td class="text-center" colspan="9">There is no data!</td>
		</tr>	
	</c:when>
	<c:otherwise>
		<c:forEach items="${list}" var="item" varStatus="status">	
		
	<%-- 	<c:out value="${item.ifmmSeq}"/> | <c:out value="${item.ifmmId}"/> | <c:out value="${item.ifmmName}"/> <br>
	 --%>	<c:out value=" ${item.ifmmSeq}"/> | <a href="/infra/member/memberView?ifmmSeq=${item.ifmmSeq}"><c:out value="${item.ifmmId}"/></a> | <c:out value="${item.ifmmName}"/> <br>
		
		</c:forEach>
	</c:otherwise>
</c:choose>	 

<%-- <nav aria-label="...">
  <ul class="pagination">
		  <c:if test="${vo.startPage gt vo.pageNumToShow}">
		                <li class="page-item"><a class="page-link" href="/infra/member/memberList?thisPage=${vo.startPage - 1}">Previous</a></li>
		</c:if>
		<c:forEach begin="${vo.startPage}" end="${vo.endPage}" varStatus="i">
			<c:choose>
				<c:when test="${i.index eq vo.thisPage}">
		                <li class="page-item active"><a class="page-link" href="/infra/member/memberList?thisPage=${i.index}">${i.index}</a></li>
				</c:when>
				<c:otherwise>             
		                <li class="page-item"><a class="page-link" href="/infra/member/memberList?thisPage=${i.index}">${i.index}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>     
		<c:if test="${vo.endPage ne vo.totalPages}">                
		                <li class="page-item"><a class="page-link" href="/infra/member/memberList?thisPage=${vo.endPage + 1}">Next</a></li>
		</c:if>  
  </ul>
</nav> --%>


<nav aria-label="...">
  <ul class="pagination">
		  <c:if test="${vo.startPage gt vo.pageNumToShow}">
		                <li class="page-item"><a class="page-link" href="javascript:goList(<c:out value='${vo.startPage -1}'/>);">Previous</a></li>
		</c:if>
		<c:forEach begin="${vo.startPage}" end="${vo.endPage}" varStatus="i">
			<c:choose>
				<c:when test="${i.index eq vo.thisPage}">
		                <li class="page-item active"><a class="page-link" href="javascript:goList(<c:out value='${i.index}'/>);">${i.index}</a></li>
				</c:when>
				<c:otherwise>             
		                <li class="page-item"><a class="page-link" href="javascript:goList(<c:out value='${i.index}'/>);">${i.index}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>     
		<c:if test="${vo.endPage ne vo.totalPages}">                
		                <li class="page-item"><a class="page-link" href="javascript:goList(<c:out value='${vo.endPage -1}'/>);">Next</a></li>
		</c:if>  
  </ul>
</nav>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type = "text/javascript">

goList = function(seq) {
	alert(seq);
	// form 객체를 가져온다
	$("#thisPage").val(seq);
	$("#formList").submit();
	// 그 가져온 객체를 전달한다.
};
s
	goForm = function(seq){
		$("#ifmmSeq").val(seq);
		$("#formList").attr("action", "/infra/code/codeGroupView");
		$("#formList").submit();
	}
	
	</script>
