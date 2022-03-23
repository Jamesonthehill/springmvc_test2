<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>


<c:out value="${item.ifcgSeq}"/> | <c:out value="${item.ifcgName}"/> | <c:out value="${item.ifcgDelNy}"/> <br>

<a href="/infra/code/codeGroupList?thisPage=<c:out value="${vo.thisPage}"/>&shOption=<c:out value="${vo.shOption}"/>&shValue=<c:out value="${vo.shValue}"/>">목록</a>
<a href="/infra/code/codeGroupForm2?ifcgSeq=<c:out value="${item.ifcgSeq}"/>">수정</a>
<a href="/infra/code/codeGroupDele?ifcgSeq=<c:out value="${item.ifcgSeq}"/>" id="btnDelete">삭제(진짜)</a>
<a href="/infra/code/codeGroupNele?ifcgSeq=<c:out value="${item.ifcgSeq}"/>" id="btnupdateDelete">삭제(가짜)</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> <!-- 이거없으면 script 안된다.  -->


<script type=text/javascript>
	$("#btnDelete").on("click", function(){ /* // 아이디면 샵 클래스면 점  btn 앞을 말한거다. */
	// confirm("진짜 삭제?") // alert 확인버튼 밖에 없다
	var answer = confirm("삭제 하시겠습니까?")
	if(answer){
	}
		else {
		alert("취소")
		return false;
		}
	});
</script>
<script type=text/javascript>
	$("#btnupdateDelete").on("click", function(){ /* // 아이디면 샵 클래스면 점  btn 앞을 말한거다. */
	// confirm("진짜 삭제?") // alert 확인버튼 밖에 없다
	var answer = confirm("가짜삭제 하시겠습니까?")
	if(answer){
	}
		else {
		alert("취소")
		return false;
		}
	});
</script>
