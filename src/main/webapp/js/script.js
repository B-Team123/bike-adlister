import { keys } from './keys.js';

const fileUploads = document.querySelectorAll('label.profile-pic-upload');
const filestackClient = filestack.init(keys.filestack);
const avatar = document.querySelector('.avatar');

fileUploads.forEach(label => {
  // const input = label.querySelector("input[type=file]");
  const filestackOptions = {
    maxFiles:        multiple ? 10 : 1,
    imageMax:        [600, 600],
    transformations: {
      crop:   false,
      circle: true,
      rotate: false,
      force:  true
    },
    onUploadDone:    response => {
      const event = new Event('change');
      const form = document.querySelector('#avatar-form');
      // avatarWrapper.classList.toggle('hidden');
      const hiddenInputs = label.querySelectorAll('input[type=hidden]');
      if (hiddenInputs) {
        hiddenInputs.forEach(input => {
          input.remove();
        });
      }
      response.filesUploaded.forEach(file => {
        console.log(file);

        const hiddenInput = document.createElement('input');
        hiddenInput.type = 'hidden';
        hiddenInput.name = 'photo';
        hiddenInput.id = file.uploadId;
        hiddenInput.value = file.url;
        label.appendChild(hiddenInput);

        const userAvatarDiv = document.querySelector('.user-avatar');
        userAvatarDiv.dataset.uploadId = file.uploadId;
      });
      form.submit();
    },
  };
  const avatarWrapper = document.querySelector('.avatar-wrapper') || label;
  const multiple = label.hasAttribute('multiple');

})
avatar.addEventListener('click', function (e) {
  e.preventDefault();
  const hiddenInput = label.querySelector(`input[id="${file.uploadId}"]`);
  hiddenInput.remove();
  filestackClient.picker(filestackOptions).open();
})


const removeAttributes = (element, ...attributes) => {
  attributes.forEach(att => element.removeAttribute(att))
}

