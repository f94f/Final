define(['model/ordenDespachoModel'], function(ordenDespachoModel) {
    App.Controller._OrdenDespachoController = Backbone.View.extend({
        initialize: function(options) {
            this.modelClass = options.modelClass;
            this.listModelClass = options.listModelClass;
            this.showEdit = true;
            this.showDelete = true;
            this.editTemplate = _.template($('#ordenDespacho').html());
            this.listTemplate = _.template($('#ordenDespachoList').html());
            if (!options || !options.componentId) {
                this.componentId = _.random(0, 100) + "";
            }else{
				this.componentId = options.componentId;
		    }
            var self = this;
            Backbone.on(this.componentId + '-' + 'ordenDespacho-create', function(params) {
                self.create(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenDespacho-list', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenDespacho-edit', function(params) {
                self.edit(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenDespacho-delete', function(params) {
                self.destroy(params);
            });
            Backbone.on(this.componentId + '-' + 'post-ordenDespacho-delete', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenDespacho-save', function(params) {
                self.save(params);
            });
            if(self.postInit){
            	self.postInit(options);
            }
        },
        create: function() {
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenDespacho-create')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenDespacho-create', {view: this});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenDespacho-create', {view: this});
                this.currentOrdenDespachoModel = new this.modelClass();
                this._renderEdit();
                Backbone.trigger(this.componentId + '-' + 'post-ordenDespacho-create', {view: this});
            }
        },
        list: function(params) {
            if (params) {
                var data = params.data;
            }
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenDespacho-list')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenDespacho-list', {view: this, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenDespacho-list', {view: this, data: data});
                var self = this;
				if(!this.ordenDespachoModelList){
                 this.ordenDespachoModelList = new this.listModelClass();
				}
                this.ordenDespachoModelList.fetch({
                    data: data,
                    success: function() {
                        self._renderList();
                        Backbone.trigger(self.componentId + '-' + 'post-ordenDespacho-list', {view: self});
                    },
                    error: function(mode, error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenDespacho-list', view: self, error: error});
                    }
                });
            }
        },
        edit: function(params) {
            var id = params.id;
            var data = params.data;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenDespacho-edit')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenDespacho-edit', {view: this, id: id, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenDespacho-edit', {view: this, id: id, data: data});
                if (this.ordenDespachoModelList) {
                    this.currentOrdenDespachoModel = this.ordenDespachoModelList.get(id);
                    this._renderEdit();
                    Backbone.trigger(this.componentId + '-' + 'post-ordenDespacho-edit', {view: this, id: id, data: data});
                } else {
                    var self = this;
                    this.currentOrdenDespachoModel = new this.modelClass({id: id});
                    this.currentOrdenDespachoModel.fetch({
                        data: data,
                        success: function() {
                            self._renderEdit();
                            Backbone.trigger(self.componentId + '-' + 'post-ordenDespacho-edit', {view: this, id: id, data: data});
                        },
                        error: function() {
                            Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenDespacho-edit', view: self, id: id, data: data, error: error});
                        }
                    });
                }
            }
        },
        destroy: function(params) {
            var id = params.id;
            var self = this;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenDespacho-delete')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenDespacho-delete', {view: this, id: id});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenDespacho-delete', {view: this, id: id});
                var deleteModel;
                if (this.ordenDespachoModelList) {
                    deleteModel = this.ordenDespachoModelList.get(id);
                } else {
                    deleteModel = new this.modelClass({id: id});
                }
                deleteModel.destroy({
                    success: function() {
                        Backbone.trigger(self.componentId + '-' + 'post-ordenDespacho-delete', {view: self, model: deleteModel});
                    },
                    error: function() {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenDespacho-delete', view: self, error: error});
                    }
                });
            }
        },
        save: function() {
            var self = this;
            var model = $('#' + this.componentId + '-ordenDespachoForm').serializeObject();
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenDespacho-save')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenDespacho-save', {view: this, model : model});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenDespacho-save', {view: this, model : model});
                this.currentOrdenDespachoModel.set(model);
                this.currentOrdenDespachoModel.save({},
                        {
                            success: function(model) {
                                Backbone.trigger(self.componentId + '-' + 'post-ordenDespacho-save', {model: self.currentOrdenDespachoModel});
                            },
                            error: function(error) {
                                Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenDespacho-save', view: self, error: error});
                            }
                        });
            }
        },
        _renderList: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.listTemplate({ordenDespachos: self.ordenDespachoModelList.models, componentId: self.componentId, showEdit : self.showEdit , showDelete : self.showDelete}));
                self.$el.slideDown("fast");
            });
        },
        _renderEdit: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.editTemplate({ordenDespacho: self.currentOrdenDespachoModel, componentId: self.componentId , showEdit : self.showEdit , showDelete : self.showDelete
 
				}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller._OrdenDespachoController;
});