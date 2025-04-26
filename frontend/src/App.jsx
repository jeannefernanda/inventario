import React, { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

const API_URL = "http://localhost:8080/inventario";

export default function App() {
  const [patrimonios, setPatrimonios] = useState([]);
  const [formData, setFormData] = useState({ nome: "", descricao: "" });
  const [editingId, setEditingId] = useState(null);
  const [showForm, setShowForm] = useState(false);

  const fetchData = async () => {
    const response = await axios.get(`${API_URL}?nome=string&descricao=string&localizacao=string`);
    setPatrimonios(response.data.content);
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (editingId) {
      await axios.put(API_URL, { id: editingId, ...formData });
    } else {
      await axios.post(API_URL, formData);
    }
    setFormData({ nome: "", descricao: "", localizacao: "" });
    setEditingId(null);
    setShowForm(false);
    fetchData();
  };

  const handleEdit = (p) => {
    setFormData({ nome: p.nome, descricao: p.descricao , localizacao: p.localizacao });
    setEditingId(p.id);
    setShowForm(true);
  };

  const handleDelete = async (id) => {
    if (confirm("Deseja excluir este item?")) {
      await axios.delete(`${API_URL}/${id}`);
      fetchData();
    }
  };

  return (
    <div className="container">
      <h1>Inventário de Patrimônios</h1>
      <button onClick={() => setShowForm(true)}>Novo Patrimônio</button>

      {showForm && (
        <form onSubmit={handleSubmit} className="form">
          <input
            placeholder="Nome"
            value={formData.nome}
            onChange={(e) => setFormData({ ...formData, nome: e.target.value })}
            required
          />
          <input
            placeholder="Descrição"
            value={formData.descricao}
            onChange={(e) =>
              setFormData({ ...formData, descricao: e.target.value })
            }
            required
          />

          <input
            placeholder="Localização"
            value={formData.localizacao}
            onChange={(e) =>
              setFormData({ ...formData, localizacao: e.target.value })
            }
            required
          />
          <div className="form-buttons">
            <button type="submit">{editingId ? "Atualizar" : "Cadastrar"}</button>
            <button type="button" onClick={() => { setShowForm(false); setFormData({ nome: "", descricao: "", localizacao: "" }); setEditingId(null); }}>
              Cancelar
            </button>
          </div>
        </form>
      )}

      <table>
        <thead>
          <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Localização</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {patrimonios.map((p) => (
            <tr key={p.id}>
              <td>{p.nome}</td>
              <td>{p.descricao}</td>
              <td>{p.localizacao}</td>
              <td>
                <button onClick={() => handleEdit(p)}>Editar</button>
                <button onClick={() => handleDelete(p.id)}>Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
