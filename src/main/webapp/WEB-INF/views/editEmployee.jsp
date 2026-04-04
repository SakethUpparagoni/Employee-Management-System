<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Employee</title>

<!-- Bootstrap CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body class="bg-light">

	<div class="container mt-5">

		<div class="card shadow p-4">
			<h3 class="text-center mb-4">Edit Employee</h3>

			<form action="updateEmployee" method="post">

				<input type="hidden" name="id" value="${employee.employeId}" />

				<div class="mb-3">
					<label class="form-label">Name</label> <input type="text"
						name="name" class="form-control" value="${employee.employeName}"
						required>
				</div>

				<div class="mb-3">
					<label class="form-label">Email</label> <input type="email"
						name="email" class="form-control" value="${employee.employeMail}"
						required>
				</div>

				<div class="mb-3">
					<label class="form-label">Password</label> <input type="text"
						name="password" class="form-control"
						value="${employee.loginPassword}" required>
				</div>

				<!-- 🔒 Role only visible for Admin -->
				<c:if test="${loggedUser.roleOfEmployee == 'Admin'}">
					<div class="mb-3">
						<label class="form-label">Role</label> <select name="role"
							class="form-select">
							<option value="Admin"
								${employee.roleOfEmployee == 'Admin' ? 'selected' : ''}>
								Admin</option>
							<option value="Employee"
								${employee.roleOfEmployee == 'Employee' ? 'selected' : ''}>
								Employee</option>
						</select>
					</div>
				</c:if>

				<div class="d-flex justify-content-between">
					<a href="empList" class="btn btn-secondary">Back</a>
					<button type="submit" class="btn btn-primary">Update</button>
				</div>

			</form>
		</div>

	</div>

</body>
</html>