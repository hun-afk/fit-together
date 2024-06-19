<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:choose>
	<c:when test="${empty title }">
		<title>핏투게더</title>
	</c:when>
	<c:otherwise>
		<title>${title }::핏투게더</title>
	</c:otherwise>
</c:choose>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/style.css?<%=System.currentTimeMillis() %>" />
</head>
<body>
	<div class="container px-1">
		<div class="my-3">
			로그온 메뉴바 들어갈 자리
		</div>
		<h2 class="my-2">등록된 체육행사들</h2>
		
		<div style="display: flex; flex-wrap: wrap;">
			<c:forEach items="${events }" var="e">
				<div style="width: 50%; padding: 4px;">
					<div class="border-rounded p-3 item">

						<div style="display: flex; justify-content: space-between;">
							<span class="fs-3">
								<c:url value="/events/${e.event.id }" var="link"/>
								<a href="${link }">${e.event.title }</a>
								</span>
							<span class="warning"># ${e.event.tag }</span>
							<span class="warning"># ${e.gym.name }</span>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>