import { keys } from './keys.js';

// file upload
const adUploads = document.querySelectorAll("label.ad-upload");
const filestackClient = filestack.init(keys.filestack);
adUploads.forEach(label => {
  const adThumbnailDisplay = document.querySelector('.ad-thumbnail-display');
  const multiple = label.hasAttribute("multiple");
  const filestackOptions = {
    maxFiles:     5,
    imageMax:     [600, 600],
    onUploadDone: response => {
      // trigger form change event
      const event = new Event("change");
      const form = label.closest("form");
      // clear all current images from media grid
      adThumbnailDisplay.innerHTML = "";
      // clear all current hidden inputs
      const hiddenInputs = label.querySelectorAll("input[type=hidden]");
      if (hiddenInputs) {
        hiddenInputs.forEach(input => {
          input.remove();
        });
      }
      // console.log(response);
      response.filesUploaded.forEach(file => {
        // create a hidden input for each file uploaded
        console.log(file);
        const hiddenInput = document.createElement("input");
        hiddenInput.type = "hidden";
        hiddenInput.name = "photos";
        hiddenInput.id = file.uploadId;
        hiddenInput.value = file.url;
        label.appendChild(hiddenInput);

        // create a thumbnail for each file uploaded
        const thumbnail = document.createElement("div");
        thumbnail.dataset.uploadId = file.uploadId;
        thumbnail.classList.add("upload-thumbnail");
        thumbnail.innerHTML = `
                        <img src="${file.url}" alt="${file.filename}">
                        <button class="upload-remove" type="button" aria-label="Remove file">
                            X
                        </button>
                    `;
        adThumbnailDisplay.appendChild(thumbnail);
        const removeButton = thumbnail.querySelector(".upload-remove");
        removeButton.addEventListener("click", function () {
          // remove hidden input
          const hiddenInput = label.querySelector(`input[id="${file.uploadId}"]`);
          hiddenInput.remove();
          // remove thumbnail
          this.closest(".upload-thumbnail").remove();
          form.dispatchEvent(event);
        });
      });
      form.dispatchEvent(event);
    },
  };
  label.addEventListener("click", function (e) {
    e.preventDefault();
    console.log('fired event')
    filestackClient.picker(filestackOptions).open();
  });
});