define(['model/inventarioModel'], function(inventarioModel) {
    App.Controller._InventarioController = Backbone.View.extend({
        initialize: function(options) {
            this.modelClass = options.modelClass;
            this.listModelClass = options.listModelClass;
            this.showEdit = true;
            this.showDelete = true;
            this.editTemplate = _.template($('#inventario').html());
            this.listTemplate = _.template($('#inventarioList').html());
            if (!options || !options.componentId) {
                this.componentId = _.random(0, 100) + "";
            }else{
				this.componentId = options.componentId;
		    }
            var self = this;
            Backbone.on(this.componentId + '-' + 'inventario-create', function(params) {
                self.create(params);
            });
            Backbone.on(this.componentId + '-' + 'inventario-list', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'inventario-edit', function(params) {
                self.edit(params);
            });
            Backbone.on(this.componentId + '-' + 'inventario-delete', function(params) {
                self.destroy(params);
            });
            Backbone.on(this.componentId + '-' + 'post-inventario-delete', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'inventario-save', function(params) {
                self.save(params);
            });
            if(self.postInit){
            	self.postInit(options);
            }
        },
        create: function() {
            if (App.Utils.eventExists(this.componentId + '-' +'instead-inventario-create')) {
                Backbone.trigger(this.componentId + '-' + 'instead-inventario-create', {view: this});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-inventario-create', {view: this});
                this.currentInventarioModel = new this.modelClass();
                this._renderEdit();
                Backbone.trigger(this.componentId + '-' + 'post-inventario-create', {view: this});
            }
        },
        list: function(params) {
            if (params) {
                var data = params.data;
            }
            if (App.Utils.eventExists(this.componentId + '-' +'instead-inventario-list')) {
                Backbone.trigger(this.componentId + '-' + 'instead-inventario-list', {view: this, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-inventario-list', {view: this, data: data});
                var self = this;
				if(!this.inventarioModelList){
                 this.inventarioModelList = new this.listModelClass();
				}
                this.inventarioModelList.fetch({
                    data: data,
                    success: function() {
                        self._renderList();
                        Backbone.trigger(self.componentId + '-' + 'post-inventario-list', {view: self});
                    },
                    error: function(mode, error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'inventario-list', view: self, error: error});
                    }
                });
            }
        },
        edit: function(params) {
            var id = params.id;
            var data = params.data;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-inventario-edit')) {
                Backbone.trigger(this.componentId + '-' + 'instead-inventario-edit', {view: this, id: id, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-inventario-edit', {view: this, id: id, data: data});
                if (this.inventarioModelList) {
                    this.currentInventarioModel = this.inventarioModelList.get(id);
                    this._renderEdit();
                    Backbone.trigger(this.componentId + '-' + 'post-inventario-edit', {view: this, id: id, data: data});
                } else {
                    var self = this;
                    this.currentInventarioModel = new this.modelClass({id: id});
                    this.currentInventarioModel.fetch({
                        data: data,
                        success: function() {
                            self._renderEdit();
                            Backbone.trigger(self.componentId + '-' + 'post-inventario-edit', {view: this, id: id, data: data});
                        },
                        error: function() {
                            Backbone.trigger(self.componentId + '-' + 'error', {event: 'inventario-edit', view: self, id: id, data: data, error: error});
                        }
                    });
                }
            }
        },
        destroy: function(params) {
            var id = params.id;
            var self = this;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-inventario-delete')) {
                Backbone.trigger(this.componentId + '-' + 'instead-inventario-delete', {view: this, id: id});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-inventario-delete', {view: this, id: id});
                var deleteModel;
                if (this.inventarioModelList) {
                    deleteModel = this.inventarioModelList.get(id);
                } else {
                    deleteModel = new this.modelClass({id: id});
                }
                deleteModel.destroy({
                    success: function() {
                        Backbone.trigger(self.componentId + '-' + 'post-inventario-delete', {view: self, model: deleteModel});
                    },
                    error: function() {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'inventario-delete', view: self, error: error});
                    }
                });
            }
        },
        save: function() {
            var self = this;
            var model = $('#' + this.componentId + '-inventarioForm').serializeObject();
            if (App.Utils.eventExists(this.componentId + '-' +'instead-inventario-save')) {
                Backbone.trigger(this.componentId + '-' + 'instead-inventario-save', {view: this, model : model});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-inventario-save', {view: this, model : model});
                this.currentInventarioModel.set(model);
                this.currentInventarioModel.save({},
                        {
                            success: function(model) {
                                Backbone.trigger(self.componentId + '-' + 'post-inventario-save', {model: self.currentInventarioModel});
                            },
                            error: function(error) {
                                Backbone.trigger(self.componentId + '-' + 'error', {event: 'inventario-save', view: self, error: error});
                            }
                        });
            }
        },
        _renderList: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.listTemplate({inventarios: self.inventarioModelList.models, componentId: self.componentId, showEdit : self.showEdit , showDelete : self.showDelete}));
                self.$el.slideDown("fast");
            });
        },
        _renderEdit: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.editTemplate({inventario: self.currentInventarioModel, componentId: self.componentId , showEdit : self.showEdit , showDelete : self.showDelete
 
				}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller._InventarioController;
});