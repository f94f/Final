define(['model/ordenReaprovicionamientoModel'], function(ordenReaprovicionamientoModel) {
    App.Controller._OrdenReaprovicionamientoController = Backbone.View.extend({
        initialize: function(options) {
            this.modelClass = options.modelClass;
            this.listModelClass = options.listModelClass;
            this.showEdit = true;
            this.showDelete = true;
            this.editTemplate = _.template($('#ordenReaprovicionamiento').html());
            this.listTemplate = _.template($('#ordenReaprovicionamientoList').html());
            if (!options || !options.componentId) {
                this.componentId = _.random(0, 100) + "";
            }else{
				this.componentId = options.componentId;
		    }
            var self = this;
            Backbone.on(this.componentId + '-' + 'ordenReaprovicionamiento-create', function(params) {
                self.create(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenReaprovicionamiento-list', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenReaprovicionamiento-edit', function(params) {
                self.edit(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenReaprovicionamiento-delete', function(params) {
                self.destroy(params);
            });
            Backbone.on(this.componentId + '-' + 'post-ordenReaprovicionamiento-delete', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'ordenReaprovicionamiento-save', function(params) {
                self.save(params);
            });
            if(self.postInit){
            	self.postInit(options);
            }
        },
        create: function() {
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenReaprovicionamiento-create')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenReaprovicionamiento-create', {view: this});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenReaprovicionamiento-create', {view: this});
                this.currentOrdenReaprovicionamientoModel = new this.modelClass();
                this._renderEdit();
                Backbone.trigger(this.componentId + '-' + 'post-ordenReaprovicionamiento-create', {view: this});
            }
        },
        list: function(params) {
            if (params) {
                var data = params.data;
            }
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenReaprovicionamiento-list')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenReaprovicionamiento-list', {view: this, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenReaprovicionamiento-list', {view: this, data: data});
                var self = this;
				if(!this.ordenReaprovicionamientoModelList){
                 this.ordenReaprovicionamientoModelList = new this.listModelClass();
				}
                this.ordenReaprovicionamientoModelList.fetch({
                    data: data,
                    success: function() {
                        self._renderList();
                        Backbone.trigger(self.componentId + '-' + 'post-ordenReaprovicionamiento-list', {view: self});
                    },
                    error: function(mode, error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenReaprovicionamiento-list', view: self, error: error});
                    }
                });
            }
        },
        edit: function(params) {
            var id = params.id;
            var data = params.data;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenReaprovicionamiento-edit')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenReaprovicionamiento-edit', {view: this, id: id, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenReaprovicionamiento-edit', {view: this, id: id, data: data});
                if (this.ordenReaprovicionamientoModelList) {
                    this.currentOrdenReaprovicionamientoModel = this.ordenReaprovicionamientoModelList.get(id);
                    this._renderEdit();
                    Backbone.trigger(this.componentId + '-' + 'post-ordenReaprovicionamiento-edit', {view: this, id: id, data: data});
                } else {
                    var self = this;
                    this.currentOrdenReaprovicionamientoModel = new this.modelClass({id: id});
                    this.currentOrdenReaprovicionamientoModel.fetch({
                        data: data,
                        success: function() {
                            self._renderEdit();
                            Backbone.trigger(self.componentId + '-' + 'post-ordenReaprovicionamiento-edit', {view: this, id: id, data: data});
                        },
                        error: function() {
                            Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenReaprovicionamiento-edit', view: self, id: id, data: data, error: error});
                        }
                    });
                }
            }
        },
        destroy: function(params) {
            var id = params.id;
            var self = this;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenReaprovicionamiento-delete')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenReaprovicionamiento-delete', {view: this, id: id});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenReaprovicionamiento-delete', {view: this, id: id});
                var deleteModel;
                if (this.ordenReaprovicionamientoModelList) {
                    deleteModel = this.ordenReaprovicionamientoModelList.get(id);
                } else {
                    deleteModel = new this.modelClass({id: id});
                }
                deleteModel.destroy({
                    success: function() {
                        Backbone.trigger(self.componentId + '-' + 'post-ordenReaprovicionamiento-delete', {view: self, model: deleteModel});
                    },
                    error: function() {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenReaprovicionamiento-delete', view: self, error: error});
                    }
                });
            }
        },
        save: function() {
            var self = this;
            var model = $('#' + this.componentId + '-ordenReaprovicionamientoForm').serializeObject();
            if (App.Utils.eventExists(this.componentId + '-' +'instead-ordenReaprovicionamiento-save')) {
                Backbone.trigger(this.componentId + '-' + 'instead-ordenReaprovicionamiento-save', {view: this, model : model});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-ordenReaprovicionamiento-save', {view: this, model : model});
                this.currentOrdenReaprovicionamientoModel.set(model);
                this.currentOrdenReaprovicionamientoModel.save({},
                        {
                            success: function(model) {
                                Backbone.trigger(self.componentId + '-' + 'post-ordenReaprovicionamiento-save', {model: self.currentOrdenReaprovicionamientoModel});
                            },
                            error: function(error) {
                                Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenReaprovicionamiento-save', view: self, error: error});
                            }
                        });
            }
        },
        _renderList: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.listTemplate({ordenReaprovicionamientos: self.ordenReaprovicionamientoModelList.models, componentId: self.componentId, showEdit : self.showEdit , showDelete : self.showDelete}));
                self.$el.slideDown("fast");
            });
        },
        _renderEdit: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.editTemplate({ordenReaprovicionamiento: self.currentOrdenReaprovicionamientoModel, componentId: self.componentId , showEdit : self.showEdit , showDelete : self.showDelete
 
				}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller._OrdenReaprovicionamientoController;
});