define(['model/ordenFabricacionModel'], function(ordenFabricacionModel) {
    App.Controller._OrdenFabricacionController = Backbone.View.extend({
        initialize: function(options) {
            this.modelClass = options.modelClass;
            this.listModelClass = options.listModelClass;
            this.showEdit = true;
            this.showDelete = true;
            this.editTemplate = _.template($('#ordenFabricacion').html());
            this.listTemplate = _.template($('#ordenFabricacionList').html());
            if (!options || !options.componentId) {
                this.componentId = _.random(0, 100) + "";
            }else{
				this.componentId = options.componentId;
		    }
            var self = this;
            Backbone.on(this.componentId + '-' + 'ordenFabricacion-create', function(params) {
                self.create(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenFabricacion-list', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenFabricacion-edit', function(params) {
                self.edit(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenFabricacion-delete', function(params) {
                self.destroy(params);
            });
            Backbone.on(this.componentId + '-' + 'post-ordenFabricacion-delete', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenFabricacion-save', function(params) {
                self.save(params);
            });
            if(self.postInit){
            	self.postInit(options);
            }
        },
        create: function() {
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenFabricacion-create')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenFabricacion-create', {view: this});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenFabricacion-create', {view: this});
                this.currentOrdenFabricacionModel = new this.modelClass();
                this._renderEdit();
                Backbone.trigger(this.componentId + '-' + 'post-ordenFabricacion-create', {view: this});
            }
        },
        list: function(params) {
            if (params) {
                var data = params.data;
            }
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenFabricacion-list')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenFabricacion-list', {view: this, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenFabricacion-list', {view: this, data: data});
                var self = this;
				if(!this.ordenFabricacionModelList){
                 this.ordenFabricacionModelList = new this.listModelClass();
				}
                this.ordenFabricacionModelList.fetch({
                    data: data,
                    success: function() {
                        self._renderList();
                        Backbone.trigger(self.componentId + '-' + 'post-ordenFabricacion-list', {view: self});
                    },
                    error: function(mode, error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenFabricacion-list', view: self, error: error});
                    }
                });
            }
        },
        edit: function(params) {
            var id = params.id;
            var data = params.data;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenFabricacion-edit')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenFabricacion-edit', {view: this, id: id, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenFabricacion-edit', {view: this, id: id, data: data});
                if (this.ordenFabricacionModelList) {
                    this.currentOrdenFabricacionModel = this.ordenFabricacionModelList.get(id);
                    this._renderEdit();
                    Backbone.trigger(this.componentId + '-' + 'post-ordenFabricacion-edit', {view: this, id: id, data: data});
                } else {
                    var self = this;
                    this.currentOrdenFabricacionModel = new this.modelClass({id: id});
                    this.currentOrdenFabricacionModel.fetch({
                        data: data,
                        success: function() {
                            self._renderEdit();
                            Backbone.trigger(self.componentId + '-' + 'post-ordenFabricacion-edit', {view: this, id: id, data: data});
                        },
                        error: function() {
                            Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenFabricacion-edit', view: self, id: id, data: data, error: error});
                        }
                    });
                }
            }
        },
        destroy: function(params) {
            var id = params.id;
            var self = this;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenFabricacion-delete')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenFabricacion-delete', {view: this, id: id});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenFabricacion-delete', {view: this, id: id});
                var deleteModel;
                if (this.ordenFabricacionModelList) {
                    deleteModel = this.ordenFabricacionModelList.get(id);
                } else {
                    deleteModel = new this.modelClass({id: id});
                }
                deleteModel.destroy({
                    success: function() {
                        Backbone.trigger(self.componentId + '-' + 'post-ordenFabricacion-delete', {view: self, model: deleteModel});
                    },
                    error: function() {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenFabricacion-delete', view: self, error: error});
                    }
                });
            }
        },
        save: function() {
            var self = this;
            var model = $('#' + this.componentId + '-ordenFabricacionForm').serializeObject();
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenFabricacion-save')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenFabricacion-save', {view: this, model : model});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenFabricacion-save', {view: this, model : model});
                this.currentOrdenFabricacionModel.set(model);
                this.currentOrdenFabricacionModel.save({},
                        {
                            success: function(model) {
                                Backbone.trigger(self.componentId + '-' + 'post-ordenFabricacion-save', {model: self.currentOrdenFabricacionModel});
                            },
                            error: function(error) {
                                Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenFabricacion-save', view: self, error: error});
                            }
                        });
            }
        },
        _renderList: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.listTemplate({ordenFabricacions: self.ordenFabricacionModelList.models, componentId: self.componentId, showEdit : self.showEdit , showDelete : self.showDelete}));
                self.$el.slideDown("fast");
            });
        },
        _renderEdit: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.editTemplate({ordenFabricacion: self.currentOrdenFabricacionModel, componentId: self.componentId , showEdit : self.showEdit , showDelete : self.showDelete
 
				}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller._OrdenFabricacionController;
});