<template>
  <form class="writeForm">
      <table>
          <tbody>
              <tr>
                  <td>
                      <select type="text" class="category">
                        <option value>탭</option>
                        <option value="free">자유게시판</option>
                        <option value="notice">공지사항</option>
                      </select>
                  </td>
                  <td>
                      <label for="title"></label>
                      <input type="text" class="title" id="title" placeholder="제목" maxlength="90" autocomplete="off">
                  </td>
              </tr>
          </tbody>
      </table>
      <div class="editor">
            <p><textarea></textarea></p>
            <p><input type="submit"></p>
      </div>
  </form>
</template>

<script>
export default {
    name: "WriteComponent",
    data() {
        return {
            
        }
    },
}
</script>

<style>
.writeForm {
    background: gray;
    width: 500px;
    height: 300px;
}
.editor {
    border-top: solid 1px black;
    height: 500px;
}

.editor textarea {
    width: 100%;
    height: 200px;
    box-sizing: border-box;
    border: solid 2px #1E90FF;
    border-radius: 5px;
    font-size: 14x;
    resize: both;
}
</style>
