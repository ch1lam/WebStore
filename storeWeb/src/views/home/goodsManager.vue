<template>
  <div>
    <el-main>
      <el-row>
        <el-col :span="7">
          <blockquote></blockquote>
        </el-col>
        <el-col :span="10">
          <div style="margin-top: 15px;">
            <el-input placeholder="iphone" v-model="data" class="input-with-select">
              <el-select v-model="select" slot="prepend" placeholder="请选择">
                <el-option label="商品名称" value="1"></el-option>
                <el-option label="商品编号" value="2"></el-option>
                <el-option label="商品价格" value="3"></el-option>
              </el-select>
              <el-button slot="append" icon="el-icon-search" v-on:click="Search"></el-button>
            </el-input>
          </div>
        </el-col>
        <el-col :span="7">
          <blockquote></blockquote>
        </el-col>
      </el-row>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="no" label="商品编号aaaaaaaaaaaaaaaaaa" min-width="150"></el-table-column>
        <el-table-column prop="name" label="商品名称" min-width="150"></el-table-column>
        <el-table-column prop="price" label="商品价格" min-width="150"></el-table-column>
        <el-table-column prop="quantity" label="商品存货" min-width="150"></el-table-column>
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
      <el-dialog title="编辑商品" :visible.sync="editDialogVisible">
        <el-form :model="editForm">
          <el-form-item label="商品编号">
            <el-input v-model="editForm.no" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="商品名称">
            <el-input v-model="editForm.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="商品价格">
            <el-input v-model="editForm.price" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="商品存货">
            <el-input v-model="editForm.quantity" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="editDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="editGoods()">确 定</el-button>
        </div>
      </el-dialog>

      <!-- 新增对话框 -->
      <el-dialog title="新增商品" :visible.sync="addDialogVisible">
        <el-form :model="addForm">
          <el-form-item label="商品编号">
            <el-input v-model="addForm.no" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="商品名称">
            <el-input v-model="addForm.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="商品价格">
            <el-input v-model="addForm.price" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="商品存货">
            <el-input v-model="addForm.quantity" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="addDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addGoods">确 定</el-button>
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
      data: "",
      select: "",
      tableData: [],
      editDialogVisible: false,
      addDialogVisible: false,
      editForm: {
        no: "",
        name: "",
        price: "",
        quantity: "",
        id: ""
      },
      addForm: {
        no: "",
        name: "",
        price: "",
        quantity: ""
      }
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/searchGoods", {
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
  },
  methods: {
    Search(data, select) {
      axios
        .get("http://localhost:8080/searchGoods", {
          params: {
            data: this.data,
            type: this.select
          }
        })
        .then(res => {
          this.tableData = [];
          res.data.forEach(element => {
            this.tableData.push(element);
          });
        });
    },
    handleAdd() {
      this.addDialogVisible = true;
    },
    handleEdit(index, row) {
      this.editForm.no = row.no;
      this.editForm.name = row.name;
      this.editForm.price = row.price;
      this.editForm.quantity = row.quantity;
      this.editForm.id = row.id;
      this.editDialogVisible = true;
    },
    handleDelete(index, row) {
      axios
        .get("http://localhost:8080/deleteGoods", {
          params: {
            no: row.no
          }
        })
        .then(this.reload());
    },
    addGoods() {
      console.log(this.addForm);
      axios
        .get("http://localhost:8080/addGoods", {
          params: {
            no: this.addForm.no,
            name: this.addForm.name,
            price: this.addForm.price,
            quantity: this.addForm.quantity
          }
        })
        .then(this.reload());
    },
    editGoods() {
      console.log(this.addForm);
      axios
        .get("http://localhost:8080/updateGoods", {
          params: {
            no: this.editForm.no,
            name: this.editForm.name,
            price: this.editForm.price,
            quantity: this.editForm.quantity,
            id: this.editForm.id
          }
        })
        .then(this.reload());
    }
  }
};
</script>

<style scoped>
.el-select {
  width: 120px;
}
.el-table {
  width: 100%;
}
</style>
