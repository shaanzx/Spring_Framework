const baseUrl = "http://localhost:8080/10_Back_end_Web_exploded/api/v1/customers";

$(document).ready(function () {
  loadCustomers();
});

// Function to load all customers
function loadCustomers() {
  $.ajax({
    url: `${baseUrl}/getAll`,
    method: "GET",
    success: function (customers) {
      const table = $("#customerTable");
      table.empty();
      customers.forEach(customer => {
        const row = `
            <tr>
              <td><img src="${customer.profilePic}" alt="Profile Picture" width="50" height="50"></td>
              <td>${customer.id}</td>
              <td>${customer.name}</td>
              <td>${customer.address}</td>
              <td>${customer.age}</td>
              <td class="table-actions">
                <button onclick="editCustomer('${customer.id}')" class="btn-edit">Edit</button>
                <button onclick="deleteCustomer('${customer.id}')" class="btn-delete-row">Delete</button>
              </td>
            </tr>
          `;
        table.append(row);
      });
    },
    error: function (xhr, status, error) {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Failed to load customers.',
      });
    }
  });
}

function saveCustomer() {
  const id = $("#id").val();
  const name = $("#name").val();
  const address = $("#address").val();
  const age = $("#age").val();

  if (!id || !name || !address || !age) {
    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'All fields are required!',
    });
    return;
  }

  const customer = {id, name, address, age: parseInt(age)};

  $.ajax({
    url: `${baseUrl}/save`,
    method: "POST",
    contentType: "application/json",
    data: JSON.stringify(customer),
    success: function () {
      Swal.fire({
        icon: 'success',
        title: 'Success',
        text: 'Customer saved successfully!',
      });
      clearForm();
      loadCustomers();
    },
    error: function (xhr, status, error) {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Failed to save customer.',
      });
    }
  });
}

// Function to update a customer
function updateCustomer() {
  const id = $("#id").val();
  const name = $("#name").val();
  const address = $("#address").val();
  const age = $("#age").val();

  if (!id || !name || !address || !age) {
    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'All fields are required!',
    });
    return;
  }

  const customer = {id, name, address, age: parseInt(age)};

  $.ajax({
    url: `${baseUrl}/update`,
    method: "PUT",
    contentType: "application/json",
    data: JSON.stringify(customer),
    success: function () {
      Swal.fire({
        icon: 'success',
        title: 'Success',
        text: 'Customer updated successfully!',
      });
      clearForm();
      loadCustomers();
    },
    error: function (xhr, status, error) {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Failed to update customer.',
      });
    }
  });
}

// Function to delete a customer
function deleteCustomer(customerId) {
  Swal.fire({
    title: 'Are you sure?',
    text: 'You will not be able to recover this customer!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes, delete it!',
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        url: `${baseUrl}/delete/${customerId}`,
        method: "DELETE",
        success: function () {
          Swal.fire({
            icon: 'success',
            title: 'Deleted!',
            text: 'Customer deleted successfully.',
          });
          loadCustomers();
        },
        error: function (xhr, status, error) {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Failed to delete customer.',
          });
        }
      });
    }
  });
}

// Function to populate the form for editing
function editCustomer(customerId) {
  $.ajax({
    url: `${baseUrl}/getAll`,
    method: "GET",
    success: function (customers) {
      const customer = customers.find(c => c.id === customerId);
      if (customer) {
        $("#id").val(customer.id);
        $("#name").val(customer.name);
        $("#address").val(customer.address);
        $("#age").val(customer.age);
      }
    },
    error: function (xhr, status, error) {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Failed to load customer details.',
      });
    }
  });
}

// Function to clear the form
function clearForm() {
  $("#id").val("");
  $("#name").val("");
  $("#address").val("");
  $("#age").val("");
}
