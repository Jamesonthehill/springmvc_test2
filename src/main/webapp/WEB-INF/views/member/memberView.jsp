<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>


<c:out value="${item.ifmmSeq}"/> | <c:out value="${item.ifmmId}"/> | <c:out value="${item.ifmmName}"/> <br>
<a href="/infra/member/memberList?thisPage=<c:out value="${vo.thisPage}"/>&shOption=<c:out value="${vo.shOption}"/>&shValue=<c:out value="${vo.shValue}"/>">목록</a>


<a href="/infra/member/memberForm2?ifmmSeq=<c:out value="${item.ifmmSeq}"/>">수정</a>
<a href="/infra/member/memberForm?ifmmSeq=<c:out value="${item.ifmmSeq}"/>">등록</a>
<a href="/infra/member/memberDele?ifmmSeq=<c:out value="${item.ifmmSeq}"/>" id="btnDelete">삭제</a>
<a href="/infra/member/memberNele?ifmmSeq=<c:out value="${item.ifmmSeq}"/>" id="btnUpdateDelete">(가짜)삭제</a>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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
	$("#btnUpdateDelete").on("click", function(){ /* // 아이디면 샵 클래스면 점  btn 앞을 말한거다. */
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