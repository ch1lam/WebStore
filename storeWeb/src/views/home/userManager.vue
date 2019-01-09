<template>
  <div>
    <el-main>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="name" label="客户名字" min-width="150"></el-table-column>
        <el-table-column prop="rank" label="客户等级" min-width="150"></el-table-column>
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
      <!-- 编辑对话框 -->
      <el-dialog title="客户信息" :visible.sync="editDialogVisible">
        <el-form :model="editForm">
          <el-form-item label="客户名字">
            <el-input v-model="editForm.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="客户等级">
            <el-input v-model="editForm.rank" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="editDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="editGuests()">确 定</el-button>
        </div>
      </el-dialog>

      <!-- 新增对话框 -->
      <el-dialog title="新增客户" :visible.sync="addDialogVisible">
        <el-form :model="addForm">
          <el-form-item label="客户名字">
            <el-input v-model="addForm.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="客户等级">
            <el-input v-model="addForm.rank" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="addDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addGuests()">确 定</el-button>
        </div>
      </el-dialog>
    </el-main>
  </div>
</template>
<script>
import axios from "axios";
export default {
  // 注入刷新页面的依赖
  inject: ["reload"],
  data() {
    return {
      tableData: [],
      editDialogVisible: false,
      addDialogVisible: false,
      editForm: {
        name: "",
        rank: "",
        id: ""
      },
      addForm: {
        name: "",
        rank: ""
      }
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/searchGuests", {
        params: {
          data: "",
          rank: "3"
        }
      })
      .then(res => {
        this.tableData = [];
        res.data.forEach(element => {
          this.tableData.push(element);
        });
      });
  },
  methods: {
    handleAdd() {
      this.addDialogVisible = true;
    },
    handleEdit(index, row) {
      this.editForm.name = row.name;
      this.editForm.rank = row.rank;
      this.editForm.id = row.id;
      this.editDialogVisible = true;
    },
    handleDelete(index, row) {
      axios
        .get("http://localhost:8080/deleteGuests", {
          params: {
            id: row.id
          }
        })
        .then(this.reload());
    },
    editGuests() {
      console.log(this.addForm);
      axios
        .get("http://localhost:8080/updateGuests", {
          params: {
            name: this.editForm.name,
            rank: this.editForm.rank,
            id: this.editForm.id
          }
        })
        .then(this.reload());
    },
    addGuests() {
      console.log(this.addForm);
      axios
        .get("http://localhost:8080/addGuests", {
          params: {
            name: this.addForm.name,
            rank: this.addForm.rank,
          }
        })
        .then(this.reload());
    }
  }
};
</script>
<style scoped>
</style>
