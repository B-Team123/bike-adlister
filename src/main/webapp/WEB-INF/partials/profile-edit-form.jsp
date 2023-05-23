<link rel="stylesheet" href="../../styles/profile.css">
<div class="profile-edit-wrapper ${param.visible}">
	<div class="profile-edit-overlay"></div>
	<form class="profile-edit-form" action="../profile" method="POST">
		<div class="form-group">
			<label for="edit_username">Username</label>
			<input id="edit_username" name="edit_username" class="form-control" type="text" value="${username}">
		</div>
		<div class="form-group">
			<label for="edit_email">Email</label>
			<input id="edit_email" name="edit_email" class="form-control" type="email" value="${email}">
		</div>
		<div class="form-group">
			<label for="edit_phone_number">Phone Number</label>
			<input id="edit_phone_number" name="edit_phone_number" class="form-control" type="text" value="${phoneNumber}">
		</div>
		<div class="form-group">
			<label for="edit_city">City</label>
			<input id="edit_city" name="edit_city" class="form-control" type="text" value="${city}">
		</div>
		<div class="form-group">
			<label for="edit_state">State</label>
			<input id="edit_state" name="edit_state" class="form-control" type="text" value="${state}">
		</div>
		<div class="form-group">
			<label for="edit_zip">Zip Code</label>
			<input id="edit_zip" name="edit_zip" class="form-control" type="text" value="${zip}">
		</div>
		<button type="submit" class="submit-edits-btn btn btn-primary btn-block">Submit Your Changes</button>
	</form>
</div>