// // file upload
// const fileUploads = document.querySelectorAll("label.file-upload");
// const filestackClient = filestack.init(keys.filestack);
// fileUploads.forEach(label => {
//   const input = label.querySelector("input[type=file]");
//   const mediaGrid = label.nextElementSibling || label;
//   const multiple = label.hasAttribute("multiple");
//   const filestackOptions = {
//     maxFiles:       multiple ? 10 : 1,
//     onFileSelected: file => {
//       // If you throw any error in this function it will reject the file selection.
//       // The error message will be displayed to the user as an alert.
//       if (file.size > 1000 * 1000) {
//         throw new Error('File too big, select something smaller than 1MB');
//       }
//     },
//     onUploadDone:   response => {
//       // trigger form change event
//       const event = new Event("change");
//       const form = label.closest("form");
//       // clear all current images from media grid
//       mediaGrid.innerHTML = "";
//       // clear all current hidden inputs
//       const hiddenInputs = label.querySelectorAll("input[type=hidden]");
//       if (hiddenInputs) {
//         hiddenInputs.forEach(input => {
//           input.remove();
//         });
//       }
//       // console.log(response);
//       response.filesUploaded.forEach(file => {
//         // create a hidden input for each file uploaded
//         console.log(file);
//         const hiddenInput = document.createElement("input");
//         hiddenInput.type = "hidden";
//         hiddenInput.name = "photos";
//         hiddenInput.id = file.uploadId;
//         hiddenInput.value = file.url;
//         label.appendChild(hiddenInput);
//
//         // create a thumbnail for each file uploaded
//         const thumbnail = document.createElement("div");
//         thumbnail.dataset.uploadId = file.uploadId;
//         thumbnail.classList.add("upload-thumbnail");
//         thumbnail.innerHTML = `
//                         <img src="${file.url}" alt="${file.filename}">
//                         <button class="upload-remove" type="button" aria-label="Remove file">
//                             <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor">
//                                 <path d="M12 10.586L16.95 5.636a1 1 0 111.414 1.414L13.414 12l4.95 4.95a1 1 0 11-1.414 1.414L12 13.414l-4.95 4.95a1 1 0 11-1.414-1.414L10.586 12 5.636 7.05a1 1 0 111.414-1.414L12 10.586z"/>
//                             </svg>
//                         </button>
//                     `;
//         mediaGrid.appendChild(thumbnail);
//         const removeButton = thumbnail.querySelector(".upload-remove");
//         removeButton.addEventListener("click", function () {
//           // remove hidden input
//           const hiddenInput = label.querySelector(`input[id="${file.uploadId}"]`);
//           hiddenInput.remove();
//           // remove thumbnail
//           this.closest(".upload-thumbnail").remove();
//           form.dispatchEvent(event);
//         });
//       });
//       form.dispatchEvent(event);
//     },
//   };
//   label.addEventListener("click", function (e) {
//     e.preventDefault();
//     filestackClient.picker(filestackOptions).open();
//   });
// });