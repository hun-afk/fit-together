<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		<div class="my-3">로그온 메뉴바 들어갈 자리</div>
		<div class="border-rounded p-2 text-center">
			<p class="fs-3">
				<span class="warning">${event.hostId }</span> 의 체육행사 <small>✍${event.registerAt }</small>
			</p>
			<h1>
				<span class="warning">[${event.tag } ]</span>
				<c:out value="${event.title }" />
			</h1>
			<p class="fs-3">
				<c:out value="${event.description }" />
			</p>
			<p class="fs-3">
				<span>📆 ${event.openAt }</span> <span>🚩 ${gym.name }
					(${gym.location })</span> <span>😊 ${event.attendee } / ${event.capacity }</span>
			</p>
		</div>
		<div class="my-2 text-right">
			<c:choose>
				<c:when test="${flag }">
					이미 참가중인 이벤트입니다.
				</c:when>
				<c:otherwise>
					<a href="${pageContext.servletContext.contextPath }/events/join/${event.id}">
						<button class="p-2 fs-4 border-rounded">참가신청</button>
					</a>
				</c:otherwise>
			</c:choose>
		</div>
		<h3 class="my-2">참가자들(${fn:length(participants) })</h3>
		<div>
			<ul style="list-style: none">
				<li><c:forEach items="${participants }" var="one">
						<c:choose>
							<c:when test="${one.userId == event.hostId }">
								<div>
									<span class="warning">${one.userId } (주최자)</span> -
									${one.joinAt } 에 참가신청
								</div>
							</c:when>
							<c:otherwise>
								<div>${one.userId } - ${one.joinAt } 에 참가신청</div>
							</c:otherwise>
						</c:choose>
					</c:forEach></li>

			</ul>

		</div>


	</div>
</body>
</html>