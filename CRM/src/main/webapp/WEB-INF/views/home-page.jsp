<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

<jsp:include page="navbar.jsp" />

<div class="container d-flex justify-content-left my-4">
	<h4>List of Customers</h4>
</div>

<div class="container d-flex justify-content-center my-2">
	<table class="table">
		<thead>
			<tr class="table-active">
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="index" items="${customers}">
				<tr>
					<td>${ index.firstName }</td>
					<td>${ index.lastName }</td>
					<td>${ index.email }</td>
					<td><input type="hidden" value="${index.email}"
						id="customerEmail" />
						<button class="btn" onclick="editCustomer(${index.id})">
							<i class="fa-sharp fa-solid fa-pen-to-square"></i>
						</button>
						<button class="btn" onclick="deleteCustomer(${index.id})">
							<i class="fa-solid fa-trash"></i>
						</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="container">
	<br> <a href="/CustomerRelationshipManagement/addCustomer"><button
			class="btn btn-primary" onclick="addCustomer()">Add a
			customer</button></a>
</div>

<script>
	function deleteCustomer(id) {
		const email = document.getElementById("customerEmail").value
		const confirmation = confirm("Are you sure you want to delete the customer : " + email)
		if(confirmation) {
				window.location.assign("/CustomerRelationshipManagement/deleteUser/" + id)
		}
	}
	
	function editCustomer(id) {
		window.location.assign("/CustomerRelationshipManagement/editCustomer/" + id);
	}
</script>

<jsp:include page="footer.jsp" />