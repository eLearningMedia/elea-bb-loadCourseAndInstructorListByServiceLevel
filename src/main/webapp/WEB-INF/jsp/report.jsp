<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="/bbNG" prefix="bbNG"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/reportminutos.css"/>
    
	<!-- compiled and minified jQuery -->
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<bbNG:learningSystemPage title="Test" ctxId="ctx">

	<bbNG:pageHeader>
		<bbNG:pageTitleBar>
			Test
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>
	
	<h3>Instructors loaded with CourseDbLoader loadCourseAndInstructorListByServiceLevel</h3>
	<table id="instructors_course">
		<thead>
            <tr>
                <th>User Id</th>
            </tr>
        </thead>
		<tbody>
			<c:forEach items="${instructors_course}" var="item">
				<tr>
					<td>
						${item}
					</td>
				</tr>
	  		</c:forEach>
		</tbody>
	</table>
	
	<h3>Instructors loaded with CourseMembershipDbLoader loadByCourseIdAndRole</h3>
	<table id="instructors_membership">
		<thead>
            <tr>
                <th>User Id</th>
            </tr>
        </thead>
		<tbody>
			<c:forEach items="${instructors_membership}" var="item">
				<tr>
					<td>
						${item}
					</td>
				</tr>
	  		</c:forEach>
		</tbody>
	</table>
	
</bbNG:learningSystemPage>