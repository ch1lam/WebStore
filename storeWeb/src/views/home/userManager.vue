<template>
  <div>
    <el-main>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="name" label="用户名" min-width="150"></el-table-column>
        <el-table-column prop="rank" label="用户等级" min-width="150"></el-table-column>
        <el-table-column min-width="100" align="right">
          <template slot="header" slot-scope="scope">
            <el-button size="mini" @click="handleAdd">Add</el-button>
          </template>
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)"
            >Delete</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </div>
</template>
<script>
export default {
  data() {
    return {
      tableData: []
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/searchGuest", {
        params: {
          data: "",
          type: "3"
        }
      })
      .then(res => {
        this.tableData = [];
        res.data.forEach(element => {
          this.tableData.push(element);
        });
      });
  }
};
</script>
<style scoped>
</style>
